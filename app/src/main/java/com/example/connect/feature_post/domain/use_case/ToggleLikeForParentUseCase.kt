package com.example.connect.feature_post.domain.use_case

import com.example.connect.R
import com.example.connect.core.util.Resource
import com.example.connect.core.util.SimpleResource
import com.example.connect.core.util.UiText
import com.example.connect.feature_post.domain.repository.PostRepository

class ToggleLikeForParentUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        parentId: String,
        parentType: Int,
        isLiked: Boolean
    ): SimpleResource {
        return if(isLiked) {
            repository.unlikeParent(parentId, parentType)
        } else {
            repository.likeParent(parentId, parentType)
        }
    }
}