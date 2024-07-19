package com.composetest.core.data.data.datasources.remote

import com.composetest.common.providers.DateTimeProvider
import com.composetest.core.data.network.requests.AuthenticationRequest
import com.composetest.core.data.network.responses.AuthenticationResponse
import com.composetest.core.data.network.responses.UserResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class AuthenticationFakeDataSourceImpl(
    private val dateTimeProvider: DateTimeProvider,
    private val ioDispatcher: CoroutineDispatcher
) : AuthenticationDataSource {

    override suspend fun authentication(authenticationRequest: AuthenticationRequest) =
        withContext(ioDispatcher) {
            delay(2000)
            AuthenticationResponse(
                token = "43reddcdsfe434323cdf3434",
                authenticationDate = dateTimeProvider.nowDateTime.toString(),
                user = UserResponse(
                    id = "123",
                    name = "Teste",
                    email = "teste@teste.com"
                )
            )
        }
}