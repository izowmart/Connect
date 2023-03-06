package com.example.connect.feature_activity.domain.repository

import androidx.paging.PagingData
import com.example.connect.domain.models.Activity
import kotlinx.coroutines.flow.Flow

interface ActivityRepository {

    val activities: Flow<PagingData<Activity>>
}