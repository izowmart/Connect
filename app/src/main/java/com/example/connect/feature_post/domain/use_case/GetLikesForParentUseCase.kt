package com.example.connect.feature_post.domain.use_case

import com.example.connect.R
import com.example.connect.core.domain.models.UserItem
import com.example.connect.core.util.Resource
import com.example.connect.core.util.SimpleResource
import com.example.connect.core.util.UiText
import com.example.connect.feature_post.domain.repository.PostRepository

class GetLikesForParentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(parentId: String): Resource<List<UserItem>> {
        return repository.getLikesForParent(parentId)
    }
}