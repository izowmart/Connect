package com.example.connect.feature_activity.presentaion

sealed class ActivityEvent {
    data class ClickedOnUser(val userId: String): ActivityEvent()
    data class ClickedOnParent(val parentId: String): ActivityEvent()
}