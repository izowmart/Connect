package com.example.connect.feature_activity.data.remote


interface ActivityApi {

    @GET("/api/activity/get")
    suspend fun getActivities(
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): List<ActivityDto>

    companion object {
        const val BASE_URL = "http://192.168.0.3:8001/"
    }
}