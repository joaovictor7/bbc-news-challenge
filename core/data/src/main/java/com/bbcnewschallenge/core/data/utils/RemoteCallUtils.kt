package com.bbcnewschallenge.core.data.utils

import com.bbcnewschallenge.common.enums.Flavor
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import com.bbcnewschallenge.common.providers.DispatcherProvider
import com.bbcnewschallenge.core.data.providers.NetworkProvider
import com.bbcnewschallenge.core.domain.throwables.network.NetworkThrowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class RemoteCallUtils @Inject constructor(
    private val networkProvider: NetworkProvider,
    private val buildConfigProvider: BuildConfigProvider,
    private val dispatcherProvider: DispatcherProvider
) {

    suspend fun <T> executeRemoteCall(onRemoteCall: suspend () -> T): T {
        handleErrors()
        return call(onRemoteCall)
    }

    private suspend fun <T> call(onRemoteCall: suspend () -> T) =
        withContext(dispatcherProvider.io) {
            if (buildConfigProvider.get.flavor == Flavor.DEVELOP) {
                delay(FAKE_CALL_DELAY)
            }
            onRemoteCall()
        }

    private suspend fun handleErrors() = when {
        !networkProvider.internetIsConnected -> NetworkThrowable()
        else -> null
    }?.let {
        delay(10)
        throw it
    }

    private companion object {
        const val FAKE_CALL_DELAY = 2000L
    }
}