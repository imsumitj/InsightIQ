package io.lexylynx.repository

import io.lexylynx.model.ChatMessage
import org.springframework.stereotype.Repository
import java.sql.Connection
import java.sql.DriverManager

@Repository
class SqlLiteChatRepository : ChatRepository {
    private val connection: Connection = DriverManager.getConnection("jdbc:sqlite:chat_history.db")

    init {
        createChatHistoryTable()
    }

    private fun createChatHistoryTable() {
        //TODO()
    }

    override fun storeChatMessage(threadId: String, message: String, response: String) {
        // TODO("To be implemented")
        println("Call the storeChat for threadId: $threadId with message: $message")
    }

    override fun getChatHistory(): List<ChatMessage> {
        // TODO("To be implemented")
        println("chat history call")
        return mutableListOf()
    }
}
