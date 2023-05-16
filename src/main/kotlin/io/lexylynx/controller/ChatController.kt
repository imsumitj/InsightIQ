package io.lexylynx.controller

import io.lexylynx.model.ChatMessage
import io.lexylynx.repository.ChatRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat")
class ChatController(@Autowired private val chatRepository: ChatRepository) {

    @PostMapping("/message")
    fun handleIncomingMessage(@RequestBody chatMessage: ChatMessage): ResponseEntity<Unit> {
        chatRepository.storeChatMessage(chatMessage.user, chatMessage.message)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/history")
    fun getChatHistory(): ResponseEntity<List<ChatMessage>> {
        val history = chatRepository.getChatHistory()
        return ResponseEntity.ok(history)
    }
}
