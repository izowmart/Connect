package com.example.connect.core.presentation.util

import android.content.Context
import androidx.compose.runtime.Composable


@Composable
fun UiText.asString(): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> stringResource(id = this.id)
    }
}

fun UiText.asString(context: Context): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.id)
    }
}