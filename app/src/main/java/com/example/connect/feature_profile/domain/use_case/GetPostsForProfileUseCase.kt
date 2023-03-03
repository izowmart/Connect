package com.example.connect.feature_profile.domain.use_case

import com.example.connect.core.domain.models.Post
import com.example.connect.core.domain.repository.ProfileRepository
import com.example.connect.core.util.Resource

class GetPostsForProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String, page: Int): Resource<List<Post>> {
        return repository.getPostsPaged(
            userId = userId,
            page = page
        )
    }
}
