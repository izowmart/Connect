package com.example.connect.feature_chat.domain.use_case
import com.example.connect.feature_chat.domain.repository.ChatRepository
import kotlinx.coroutines.flow.Flow
import com.tinder.scarlet.WebSocket


class ObserveChatEvents(
    private val repository: ChatRepository
) {

    operator fun invoke(): Flow<WebSocket.Event> {
        return repository.observeChatEvents()
    }

}