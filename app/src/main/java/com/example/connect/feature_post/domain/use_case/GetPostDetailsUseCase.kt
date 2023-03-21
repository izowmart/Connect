package com.example.connect.feature_post.domain.use_case

import com.example.connect.core.domain.models.Post
import com.example.connect.core.util.Resource
import com.example.connect.feature_post.domain.repository.PostRepository

class GetPostDetailsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): Resource<Post> {
        return repository.getPostDetails(postId)
    }
}