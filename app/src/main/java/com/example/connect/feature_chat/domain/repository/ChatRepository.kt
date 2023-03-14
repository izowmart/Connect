package com.example.connect.feature_chat.domain.repository

import com.example.connect.core.util.Resource
import com.example.connect.feature_chat.domain.model.Chat
import com.example.connect.feature_chat.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface ChatRepository {

    fun initialize()

    suspend fun getChatsForUser(): Resource<List<Chat>>

    suspend fun getMessagesForChat(
        chatId: String,
        page: Int,
        pageSize: Int
    ): Resource<List<Message>>

    fun observeChatEvents(): Flow<Message>
    fun observeMessages(): Flow<Message>
    fun sendMessage(toId: String, text: String, chatId: String?)
}