package com.example.connect.feature_activity.presentaion

import com.example.connect.domain.models.Activity

data class ActivityState(
    val activities: List<Activity> = emptyList(),
    val isLoading: Boolean = false,
)