package com.example.connect.feature_post.presentation.person_list

import com.example.connect.core.domain.models.UserItem

data class PersonListState(
    val users: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)