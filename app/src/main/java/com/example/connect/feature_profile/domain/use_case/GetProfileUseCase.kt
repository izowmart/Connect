package com.example.connect.feature_profile.domain.use_case

import com.example.connect.core.domain.repository.ProfileRepository
import com.example.connect.core.util.Resource
import com.example.connect.feature_profile.domain.model.Profile

class GetProfileUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(userId: String): Resource<Profile> {
        return repository.getProfile(userId)
    }
}
