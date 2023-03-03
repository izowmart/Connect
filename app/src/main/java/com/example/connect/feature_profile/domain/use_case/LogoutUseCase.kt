package com.example.connect.feature_profile.domain.use_case

import com.example.connect.core.domain.repository.ProfileRepository

class LogoutUseCase(
    private val repository: ProfileRepository
) {

    operator fun invoke() {
        repository.logout()
    }
}
