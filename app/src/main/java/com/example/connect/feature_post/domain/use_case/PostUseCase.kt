package com.example.connect.feature_post.domain.use_case

import com.example.connect.R
import com.example.connect.core.domain.use_case.DeletePost
import com.example.connect.core.util.Resource
import com.example.connect.core.util.SimpleResource
import com.example.connect.core.util.UiText
import com.example.connect.feature_post.domain.repository.PostRepository

data class PostUseCases(
    val getPostsForFollows: GetPostsForFollowsUseCase,
    val createPostUseCase: CreatePostUseCase,
    val getPostDetails: GetPostDetailsUseCase,
    val getCommentsForPost: GetCommentsForPostUseCase,
    val createComment: CreateCommentUseCase,
    val toggleLikeForParent: ToggleLikeForParentUseCase,
    val getLikesForParent: GetLikesForParentUseCase,
    val deletePost: DeletePost
)