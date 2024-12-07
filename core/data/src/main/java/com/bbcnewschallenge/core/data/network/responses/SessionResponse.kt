package com.bbcnewschallenge.core.data.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class SessionResponse(
    val token: String,
    val startDate: String,
    val endDate: String
)
