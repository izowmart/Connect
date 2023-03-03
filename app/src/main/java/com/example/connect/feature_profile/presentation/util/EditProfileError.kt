package com.example.connect.feature_profile.presentation.util

sealed class EditProfileError : Error() {
    object FieldEmpty: EditProfileError()
}