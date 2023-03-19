package com.example.connect.feature_chat.presentaion.message

sealed class MessageEvent {
    object SendMessage: MessageEvent()
    data class EnteredMessage(val message: String): MessageEvent()
}
