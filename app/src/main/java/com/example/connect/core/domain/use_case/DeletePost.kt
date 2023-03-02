package com.example.connect.core.domain.use_case

class DeletePost(
    private val repository: PostRepository
) {

    suspend operator fun invoke(postId: String): SimpleResource {
        return repository.deletePost(postId)
    }
}