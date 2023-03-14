package com.example.connect.feature_chat.presentaion.chat

import com.example.connect.feature_chat.domain.model.Chat

data class ChatState(
    val chats: List<Chat> = emptyList(),
    val isLoading: Boolean = false
)
