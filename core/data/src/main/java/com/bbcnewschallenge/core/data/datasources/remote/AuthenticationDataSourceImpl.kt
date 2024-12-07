package com.bbcnewschallenge.core.data.datasources.remote

import com.bbcnewschallenge.core.data.extensions.post
import com.bbcnewschallenge.core.data.network.requests.AuthenticationRequest
import com.bbcnewschallenge.core.data.network.responses.AuthenticationResponse
import com.bbcnewschallenge.core.data.utils.RemoteCallUtils
import io.ktor.client.HttpClient
import io.ktor.client.request.setBody

internal class AuthenticationDataSourceImpl(
    private val bffApi: HttpClient,
    private val remoteCallUtils: RemoteCallUtils
) : AuthenticationDataSource {

    override suspend fun authentication(request: AuthenticationRequest) =
        remoteCallUtils.executeRemoteCall {
            bffApi.post<AuthenticationResponse>("authenticate") {
                setBody(request)
            }
        }
}