package com.example.connect.feature_post.presentation.person_list

import com.example.connect.core.util.Event

sealed class PostEvent : Event() {
    object OnLiked: PostEvent()
}