package com.example.connect.feature_activity.presentaion

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val getActivities: GetActivitiesUseCase
) : ViewModel() {

    val activities = getActivities().cachedIn(viewModelScope)

    private val _state = mutableStateOf(ActivityState())
    val state: State<ActivityState> = _state

    fun onEvent(event: ActivityEvent) {
        when(event) {
            is ActivityEvent.ClickedOnUser -> {

            }
            is ActivityEvent.ClickedOnParent -> {

            }
        }
    }
}