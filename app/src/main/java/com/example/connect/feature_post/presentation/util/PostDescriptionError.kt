package com.example.connect.feature_post.presentation.util

sealed class PostDescriptionError : Error() {
    object FieldEmpty: PostDescriptionError()
}