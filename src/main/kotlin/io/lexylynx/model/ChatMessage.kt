package io.lexylynx.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ChatMessage @JsonCreator constructor(
    @JsonProperty("threadId") val threadId: String,
    @JsonProperty("message") val message: String
)
