package com.example.connect.feature_profile.domain.use_case

import com.example.connect.core.domain.repository.ProfileRepository
import com.example.connect.core.util.Resource
import com.example.connect.feature_profile.domain.model.Skill

class GetSkillsUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(): Resource<List<Skill>> {
        return repository.getSkills()
    }
}
