package com.example.connect.feature_profile.data.remote.response

data class SkillDto(
    val name: String,
    val imageUrl: String
) {

    fun toSkill(): Skill {
        return Skill(
            name = name,
            imageUrl = imageUrl
        )
    }
}
