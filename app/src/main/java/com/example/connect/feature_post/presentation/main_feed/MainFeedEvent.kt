package com.example.connect.feature_post.presentation.main_feed

import com.example.connect.domain.models.Post

sealed class MainFeedEvent {
    data class LikedPost(val postId: String): MainFeedEvent()
    data class DeletePost(val post: Post): MainFeedEvent()
}