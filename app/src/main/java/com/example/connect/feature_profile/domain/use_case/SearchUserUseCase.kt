package com.example.connect.feature_profile.domain.use_case

import com.example.connect.core.domain.models.UserItem
import com.example.connect.core.domain.repository.ProfileRepository
import com.example.connect.core.util.Resource

class SearchUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(query: String): Resource<List<UserItem>> {
        if(query.isBlank()) {
            return Resource.Success(data = emptyList())
        }
        return repository.searchUser(query)
    }
}
