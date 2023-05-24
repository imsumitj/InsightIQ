package io.lexylynx.model

data class ChatMessage(
    val id: String,
    val timestamp: String,
    val user: String,
    val message: String
)
