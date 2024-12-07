package com.bbcnewschallenge.core.data.network.responses

import com.bbcnewschallenge.core.data.network.responses.SessionResponse
import com.bbcnewschallenge.core.data.network.responses.UserResponse
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationResponse(
    val user: UserResponse,
    val sessionResponse: SessionResponse
)
