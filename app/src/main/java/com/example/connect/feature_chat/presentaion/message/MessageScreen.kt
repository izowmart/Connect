package com.example.connect.feature_chat.presentaion.message

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.example.connect.core.presentation.components.SendTextField
import com.example.connect.R
import com.example.connect.core.presentation.components.StandardToolbar
import com.example.connect.core.presentation.theme.DarkerGreen
import com.example.connect.core.presentation.theme.ProfilePictureSizeSmall
import com.example.connect.core.presentation.theme.SpaceMedium
import com.example.connect.feature_chat.presentaion.message.components.OwnMessage
import com.example.connect.feature_chat.presentaion.message.components.RemoteMessage
import okio.ByteString.Companion.decodeBase64
import java.nio.charset.Charset

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun MessageScreen(
    remoteUserId: String,
    remoteUsername: String,
    encodedRemoteUserProfilePictureUrl: String,
    imageLoader: ImageLoader,
    onNavigateUp: () -> Unit = {},
    onNavigate: (String) -> Unit = {},
    viewModel: MessageViewModel = hiltViewModel()
) {
    val decodedRemoteUserProfilePictureUrl = remember {
        encodedRemoteUserProfilePictureUrl.decodeBase64()?.string(Charset.defaultCharset())
    }
    val pagingState = viewModel.pagingState.value
    val state = viewModel.state.value
    val lazyListState = rememberLazyListState()
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = pagingState, key2 = keyboardController) {
        viewModel.messageReceived.collect { event ->
            when (event) {
                is MessageViewModel.MessageUpdateEvent.SingleMessageUpdate,
                is MessageViewModel.MessageUpdateEvent.MessagePageLoaded -> {
                    if (pagingState.items.isEmpty()) {
                        return@collect
                    }
                    lazyListState.scrollToItem(pagingState.items.size - 1)
                }
                is MessageViewModel.MessageUpdateEvent.MessageSent -> {
                    keyboardController?.hide()
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        StandardToolbar(
            onNavigateUp = onNavigateUp,
            showBackArrow = true,
            title = {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = decodedRemoteUserProfilePictureUrl,
                        imageLoader = imageLoader
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(ProfilePictureSizeSmall)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(SpaceMedium))
                Text(
                    text = remoteUsername,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            }
        )
        Column(modifier = Modifier.weight(1f)) {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier
                    .weight(1f)
                    .padding(SpaceMedium)
            ) {
                items(pagingState.items.size) { i ->
                    val message = pagingState.items[i]
                    if (i >= pagingState.items.size - 1 && !pagingState.endReached && pagingState.isLoading){
                        viewModel.loadNextMessages() // This means that there are more messages still incomming
                    }
                    if (message.fromId == remoteUserId){
                        RemoteMessage(
                            message = message.text, 
                            formattedTime = message.formattedTime,
                            color = MaterialTheme.colors.surface,
                            textColor = MaterialTheme.colors.onBackground
                        )
                        Spacer(modifier = Modifier.height(SpaceMedium))
                    } else {
                        OwnMessage(
                            message = message.text,
                            formattedTime = message.formattedTime,
                            color = DarkerGreen,
                            textColor = MaterialTheme.colors.onBackground
                        )
                        Spacer(modifier = Modifier.height(SpaceMedium))
                    }
                    Spacer(modifier = Modifier.height(SpaceMedium))
                }
                
            }
        }

        SendTextField(
            state = viewModel.messageTextFieldState.value,
            canSendMessage = state.canSendMessage,
            onValueChange = {
                viewModel.onEvent(MessageEvent.EnteredMessage(it))
            },
            onSend = {
                viewModel.onEvent(MessageEvent.SendMessage)
            },
            hint = stringResource(id = R.string.enter_a_message)
        )
    }

}