package com.example.connect.feature_post.domain.use_case

import com.example.connect.R
import com.example.connect.core.domain.models.Comment
import com.example.connect.core.util.Resource
import com.example.connect.core.util.SimpleResource
import com.example.connect.core.util.UiText
import com.example.connect.feature_post.domain.repository.PostRepository

class GetCommentsForPostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<List<Comment>> {
        return repository.getCommentsForPost(postId)
    }
}