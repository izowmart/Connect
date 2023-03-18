package com.example.connect.feature_chat.data.repository

import coil.network.HttpException
import com.example.connect.R
import com.example.connect.core.util.Resource
import com.example.connect.core.util.UiText
import com.example.connect.feature_chat.data.remote.ChatApi
import com.example.connect.feature_chat.data.remote.ChatService
import com.example.connect.feature_chat.data.remote.data.WsClientMessage
import com.example.connect.feature_chat.di.ScarletInstance
import com.example.connect.feature_chat.domain.model.Chat
import com.example.connect.feature_chat.domain.model.Message
import com.example.connect.feature_chat.domain.repository.ChatRepository
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import okhttp3.OkHttpClient
import java.io.IOException

class ChatRepositoryImpl(
    private val chatApi: ChatApi,
    private val okHttpClient: OkHttpClient
): ChatRepository {

    private var chatService: ChatService? = null

    override fun initialize() {
       chatService = ScarletInstance.getNewInstance(okHttpClient)
    }

    override suspend fun getChatsForUser(): Resource<List<Chat>> {
      return try {
          val chats = chatApi
              .getChatsForUser()
              .mapNotNull {
                  it.toChat()
              }
          Resource.Success(data = chats)
      }catch (e: IOException){
          Resource.Error(
              uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
          )
      }catch (e: HttpException){
          Resource.Error(
              uiText = UiText.StringResource(R.string.oops_something_went_wrong)
          )
      }
    }

    override suspend fun getMessagesForChat(
        chatId: String,
        page: Int,
        pageSize: Int
    ): Resource<List<Message>> {
        return try {
            val messages = chatApi
                .getMessagesForChat(chatId, page, pageSize)
                .map { it.toMessage() }
            Resource.Success(data = messages)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override fun observeChatEvents(): Flow<WebSocket.Event> {
       return chatService?.observeEvent()
           ?.receiveAsFlow() ?: flow{}
    }

    override fun observeMessages(): Flow<Message> {
        return chatService
            ?.observeMessages()
            ?.receiveAsFlow()
            ?.map{it.toMessage()} ?: flow {}
    }

    override fun sendMessage(toId: String, text: String, chatId: String?) {
      chatService?.sendMessage(
          WsClientMessage(
              toId = toId,
              text = text,
              chatId = chatId
          )
      )
    }
}