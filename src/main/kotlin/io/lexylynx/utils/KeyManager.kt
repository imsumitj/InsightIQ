package io.lexylynx.utils

import io.lexylynx.controller.logger
import org.springframework.stereotype.Component
import java.security.InvalidKeyException
import java.util.*

@Component
class KeyManager {
    private val log = logger()

    private val keys = mutableMapOf<String, SecureKey>()

    fun getKey(threadId: String): SecureKey {
        log.info("${keys.keys}")
        return keys[threadId] ?: throw InvalidKeyException("Unknown threadId key")
    }

    fun addKey(threadId: String, secureKey: SecureKey){
        keys[threadId] = secureKey
    }

    class SecureKey(key: String) {
        private val key: CharArray = key.toCharArray()

        fun getKey(): String {
            return String(key)
        }

        fun clearKey() {
            Arrays.fill(key, ' ')
        }
    }
}
