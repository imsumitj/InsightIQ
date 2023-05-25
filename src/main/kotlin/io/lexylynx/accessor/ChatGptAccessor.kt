package io.lexylynx.accessor

import io.lexylynx.controller.logger
import io.lexylynx.utils.KeyManager
import io.lexylynx.utils.KeyManager.SecureKey
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class ChatGptAccessor(private val keyManager: KeyManager) {
    private val log = logger()

    /*
        API references:
        1. https://platform.openai.com/docs/libraries/community-libraries
        2. https://platform.openai.com/docs/api-reference/chat
        3. API keys: https://platform.openai.com/account/api-keys
     */

    private val endpointUrl = "https://api.openai.com/v1/completions"


    fun sendMessage(threadId: String, prompt: String): String {
        val key = keyManager.getKey(threadId)
        return sendRequest(prompt, key)
    }

    private fun sendRequest(prompt: String, key: SecureKey): String {
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        headers.set("Content-Type", "application/json")
        headers.set("Authorization", "Bearer ${key.getKey()}")

        val body = mapOf(
            "model" to "text-davinci-003",
            "prompt" to prompt,
            "max_tokens" to 500,
            "temperature" to 0
        )

        val httpEntity = HttpEntity(body, headers)

        val responseEntity: ResponseEntity<String> = restTemplate.exchange(
            endpointUrl,
            HttpMethod.POST,
            httpEntity,
            String::class.java
        )

        return if (responseEntity.statusCode.is2xxSuccessful) {
            responseEntity.body.toString()
        } else {
            println("Error: HTTP request failed with response code ${responseEntity.statusCode}")
            ""
        }
    }
}

