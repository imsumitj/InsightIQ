package io.lexylynx.model

data class ChatMessage(
    val id: Long,
    val timestamp: String,
    val user: String,
    val message: String
)
