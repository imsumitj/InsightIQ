package io.lexylynx.controller

import io.lexylynx.model.ChatMessage
import io.lexylynx.repository.ChatRepository
import io.lexylynx.service.ChatService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/chat")
class ChatController(@Autowired private val chatRepository: ChatRepository,
                    @Autowired private val chatService: ChatService) {

    val log = logger()

    @PostMapping("/message")
    fun handleIncomingMessage(@RequestBody chatMessage: ChatMessage): ResponseEntity<String> {
        try {
            val prompt = chatMessage.message
            val threadId = chatMessage.threadId

            val response = chatService.sendMessage(threadId, prompt)
            // TODO error handling
            chatRepository.storeChatMessage(threadId, prompt, response)
            log.info("Response to the prompt: $response")
            return ResponseEntity.ok(response)
        }catch (ex: Exception){
            log.error("Send message failed", ex)
            throw ex
        }
    }

    @GetMapping("/history")
    fun getChatHistory(): ResponseEntity<List<ChatMessage>> {
        val history = chatRepository.getChatHistory()
        return ResponseEntity.ok(history)
    }
}
