package io.lexylynx.service

import io.lexylynx.accessor.ChatGptAccessor
import io.lexylynx.controller.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.system.measureTimeMillis

@Service
class ChatService(@Autowired private val gptAccessor: ChatGptAccessor) {
    private val log = logger()

    fun sendMessage(threadId: String, prompt: String): String {
        var sendMessage = ""
        val executionTime = measureTimeMillis {
            sendMessage = gptAccessor.sendMessage(threadId, prompt)
        }
        log.info("It took $executionTime millis to get the response from OpenAI")
        return sendMessage
    }

}