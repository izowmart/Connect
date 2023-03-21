package com.example.connect.feature_chat.domain.use_case

import com.example.connect.feature_chat.domain.repository.ChatRepository

class SendMessage(
    private val repository: ChatRepository
) {

    // We observe the message if its blank which should never occur since our send button icon
    // can never be activated when nothing is typed. We also trim off the white spaces
    operator fun invoke(toId: String, text: String, chatId: String?) {
        if(text.isBlank()) {
            return
        }
        repository.sendMessage(toId, text.trim(), chatId)
    }
}