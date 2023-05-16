package io.lexylynx.repository

import io.lexylynx.model.ChatMessage
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.DriverManager

@Repository
class SqlLiteChatRepository : ChatRepository {
    private val connection: Connection = DriverManager.getConnection("jdbc:sqlite:store/chat_history.db")

    init {
        createChatHistoryTable()
    }

    private fun createChatHistoryTable() {
        TODO()
    }

    override fun storeChatMessage(user: String, message: String) {
        TODO("To be implemented")
    }

    override fun getChatHistory(): List<ChatMessage> {
        TODO("To be implemented")
    }
}
