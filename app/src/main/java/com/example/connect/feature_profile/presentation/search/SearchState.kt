package com.example.connect.feature_profile.presentation.search

import com.example.connect.core.domain.models.UserItem

data class SearchState(
    val userItems: List<UserItem> = emptyList(),
    val isLoading: Boolean = false
)