package com.bbcnewschallenge.core.data.datasources.remote

import com.bbcnewschallenge.core.data.network.requests.AuthenticationRequest
import com.bbcnewschallenge.core.data.network.responses.AuthenticationResponse

internal interface AuthenticationDataSource {

    suspend fun authentication(request: AuthenticationRequest): AuthenticationResponse
}