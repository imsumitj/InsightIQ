package io.lexylynx.accessor

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import io.lexylynx.controller.logger
import io.lexylynx.utils.KeyManager
import io.lexylynx.utils.KeyManager.SecureKey
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import kotlin.time.ExperimentalTime

@Component
class ChatGptAccessor(private val keyManager: KeyManager) {
    private val log = logger()

    private val endpointUrl = "https://api.openai.com/v1/engines/davinci-codex/completions"

    @OptIn(BetaOpenAI::class)
    fun sendMessage(threadId: String, prompt: String): String {
        val requestBody = buildRequestBody(prompt)
        val key = keyManager.getKey(threadId)
        return sendRequest(requestBody, key)
    }

    private fun buildRequestBody(prompt: String): String {
        return """
            {
                "prompt": "$prompt",
                "max_tokens": 500
            }
        """.trimIndent()
    }

    private fun sendRequest(requestBody: String, key: SecureKey): String {
        val url = URL(endpointUrl)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "POST"
        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("Authorization", "Bearer ${key.getKey()}")

        connection.doOutput = true
        val writer = OutputStreamWriter(connection.outputStream)
        writer.write(requestBody)
        writer.flush()

        val responseCode = connection.responseCode
        val response = StringBuilder()

        if (responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            var line: String? = reader.readLine()

            while (line != null) {
                response.append(line)
                line = reader.readLine()
            }
        } else {
            println("Error: HTTP request failed with response code $responseCode")
        }

        connection.disconnect()
        return response.toString()
    }
}

