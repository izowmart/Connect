package com.example.connect.feature_auth.domain.models

import com.example.connect.core.util.SimpleResource

data class LoginResult(
    val emailError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)
