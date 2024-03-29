package com.example.connect.feature_chat.presentaion.message

import com.example.connect.feature_chat.domain.model.Message

data class MessageState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false,
    val canSendMessage: Boolean = false
)