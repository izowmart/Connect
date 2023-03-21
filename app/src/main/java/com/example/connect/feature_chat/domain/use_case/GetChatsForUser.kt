package com.example.connect.feature_chat.domain.use_case

import com.example.connect.core.util.Resource
import com.example.connect.feature_chat.domain.model.Chat
import com.example.connect.feature_chat.domain.repository.ChatRepository

class GetChatsForUser(
    private val repository: ChatRepository
) {
    suspend operator fun invoke(): Resource<List<Chat>> {
        return repository.getChatsForUser()
    }
}