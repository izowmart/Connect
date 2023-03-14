package com.example.connect.feature_chat.presentaion.chat

import android.util.Base64
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import com.example.connect.core.presentation.theme.SpaceLarge
import com.example.connect.core.presentation.theme.SpaceMedium
import com.example.connect.core.util.Screen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChatScreen(
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: ChatViewModel = hiltViewModel()
) {

    val chats = viewModel.state.value.chats
    val isLoading = viewModel.state.value.isLoading

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(SpaceMedium),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(chats) { chat ->
                ChatItem(item = chat, imageLoader = imageLoader, onItemClick = {
                    onNavigate(
                        Screen.MessageScreen.route + "/${chat.remoteUserId}/${chat.remoteUsername}/${
                            Base64.encodeToString(
                                chat.remoteUserProfilePictureUrl.encodeToByteArray(),
                                0
                            )
                        }?chatId=${chat.chatId}"
                    )
                }
                )
                Spacer(modifier = Modifier.height(SpaceLarge))
            }
        }


    }
}