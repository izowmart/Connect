package com.example.connect.core.presentation.util

import com.example.connect.core.util.Event
import com.example.connect.core.util.UiText


sealed class UiEvent: Event() {
    data class ShowSnackbar(val uiText: UiText) : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    object NavigateUp : UiEvent()
    object OnLogin: UiEvent()
}