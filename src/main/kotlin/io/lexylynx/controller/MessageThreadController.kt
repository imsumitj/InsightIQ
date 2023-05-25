package io.lexylynx.controller

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.lexylynx.utils.KeyManager
import io.lexylynx.utils.KeyManager.SecureKey
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


inline fun <reified T> T.logger(): Logger {
    return LoggerFactory.getLogger(T::class.java)
}

@RestController
@RequestMapping("/threads")
@Slf4j
class MessageThreadController(private val keyManager: KeyManager) {

    val log = logger()

    @PostMapping
    fun createMessageThread(@RequestBody request: CreateMessageThreadRequest): ResponseEntity<String> {
        val threadId = generateThreadId()
        keyManager.addKey(threadId, SecureKey(request.apiKey))
        log.info("Created threadId: $threadId & keymanager updated with key $keyManager")
        return ResponseEntity.status(HttpStatus.CREATED).body(threadId)
    }


    private fun generateThreadId(): String {
        return UUID.randomUUID().toString()
    }
}



data class CreateMessageThreadRequest @JsonCreator constructor(
    @JsonProperty("apiKey") val apiKey: String,
    @JsonProperty("name") val name: String = "",
    @JsonProperty("description") val description: String = ""
)

