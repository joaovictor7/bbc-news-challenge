package com.bbcnewschallenge.core.data.utils

import com.bbcnewschallenge.common.enums.Flavor
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import com.bbcnewschallenge.common.providers.DispatcherProvider
import com.bbcnewschallenge.core.domain.errors.HttpError
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.io.IOException
import javax.inject.Inject

internal class RemoteCallUtils @Inject constructor(
    private val buildConfigProvider: BuildConfigProvider,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend fun <T> executeRemoteCall(onRemoteCall: suspend () -> T) = runCatching {
        call { onRemoteCall() }
    }.getOrElse {
        throw errorHandle(it)
    }

    private suspend fun <T> call(onRemoteCall: suspend () -> T) =
        withContext(dispatcherProvider.io) {
            if (buildConfigProvider.get.flavor == Flavor.DEVELOP) {
                delay(FAKE_CALL_DELAY)
            }
            onRemoteCall()
        }

    private fun errorHandle(error: Throwable) = when (error) {
        is ClientRequestException -> {
            if (error.response.status == HttpStatusCode.Unauthorized)
                HttpError.Unauthorized()
            else {
                HttpError.Request(error.message)
            }
        }
        is ServerResponseException -> HttpError.Request(error.message)
        is IOException -> HttpError.Network()
        else -> HttpError.Unknown(error.message)
    }

    private companion object {
        const val FAKE_CALL_DELAY = 2000L
    }
}