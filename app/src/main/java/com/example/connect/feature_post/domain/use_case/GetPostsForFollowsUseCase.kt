package com.example.connect.feature_post.domain.use_case

import com.example.connect.R
import com.example.connect.core.util.Constants
import com.example.connect.core.util.Resource
import com.example.connect.core.util.SimpleResource
import com.example.connect.core.util.UiText
import com.example.connect.domain.models.Post
import com.example.connect.feature_post.domain.repository.PostRepository

class GetPostsForFollowsUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        page: Int,
        pageSize: Int = Constants.DEFAULT_PAGE_SIZE
    ): Resource<List<Post>> {
        return repository.getPostsForFollows(page, pageSize)
    }
}