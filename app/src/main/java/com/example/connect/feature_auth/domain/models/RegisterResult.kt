package com.example.connect.feature_auth.domain.models

import com.example.connect.core.util.SimpleResource

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)