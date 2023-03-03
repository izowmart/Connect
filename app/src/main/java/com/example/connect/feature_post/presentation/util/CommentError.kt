package com.example.connect.feature_post.presentation.util

import com.example.connect.core.util.Error

sealed class CommentError : Error(){
    object FieldEmpty: CommentError()
}