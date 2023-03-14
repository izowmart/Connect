package com.example.connect.feature_chat.domain.use_case

import com.example.connect.core.util.Constants.DEFAULT_PAGE_SIZE
import com.example.connect.core.util.Resource
import com.example.connect.feature_chat.domain.model.Message
import com.example.connect.feature_chat.domain.repository.ChatRepository

class GetMessagesForChat(
    private val repository: ChatRepository
) {

    suspend operator fun invoke(
        chatId: String,
        page: Int,
        pageSize: Int = DEFAULT_PAGE_SIZE
    ): Resource<List<Message>> {
        return repository.getMessagesForChat(
            chatId, page, pageSize
        )
    }
}