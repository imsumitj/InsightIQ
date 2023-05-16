package io.lexylynx.repository

import io.lexylynx.model.ChatMessage

interface ChatRepository {
    fun storeChatMessage(user: String, message: String)
    fun getChatHistory(): List<ChatMessage>
}