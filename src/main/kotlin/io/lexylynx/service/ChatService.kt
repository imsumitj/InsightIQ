package io.lexylynx.service

import io.lexylynx.accessor.ChatGptAccessor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChatService(@Autowired private val gptAccessor: ChatGptAccessor) {

    fun sendMessage(threadId: String, prompt: String): String{
            return gptAccessor.sendMessage(threadId, prompt)
    }

}