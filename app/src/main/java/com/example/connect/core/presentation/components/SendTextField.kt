package com.example.connect.core.presentation.components

import androidx.compose.ui.res.stringResource
import com.example.connect.R

@Composable
fun SendTextField(
    state: StandardTextFieldState,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit,
    hint: String = "",
    canSendMessage: Boolean = true,
    isLoading: Boolean = false,
    focusRequester: FocusRequester = FocusRequester()
) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxWidth()
            .padding(SpaceLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StandardTextField(
            text = state.text,
            onValueChange = onValueChange,
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier
                .weight(1f),
            hint = hint,
            focusRequester = focusRequester
        )
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .size(24.dp),
                strokeWidth = 2.dp
            )
        } else {
            IconButton(
                onClick = onSend,
                enabled = state.error == null || !canSendMessage
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    tint = if (state.error == null && canSendMessage) {
                        MaterialTheme.colors.primary
                    } else MaterialTheme.colors.background,
                    contentDescription = stringResource(id = R.string.send_comment)
                )
            }
        }
    }
}