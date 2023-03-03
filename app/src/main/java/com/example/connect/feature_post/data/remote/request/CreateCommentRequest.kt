package com.example.connect.feature_post.data.remote.request

data class CreateCommentRequest(
    val comment: String,
    val postId: String,
)