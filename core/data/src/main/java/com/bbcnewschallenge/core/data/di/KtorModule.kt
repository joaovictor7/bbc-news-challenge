package com.bbcnewschallenge.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

private const val TIMEOUT = 20000L

@Module
@InstallIn(SingletonComponent::class)
internal object KtorModule {

    @Provides
    @Singleton
    fun ktorClient(): HttpClient = HttpClient(Android) {
        expectSuccess = true
        defaultRequest {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
        }
//        HttpResponseValidator {
//            handleResponseExceptionWithRequest { exception, _ ->
//                val clientException = exception as? ClientRequestException
//                when (clientException?.response?.status) {
//                    HttpStatusCode.Unauthorized -> throw UnauthorizedRequestThrowable(
//                        message = clientException.message
//                    )
//                }
//            }
//        }
        install(HttpTimeout) {
            requestTimeoutMillis = TIMEOUT
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.ALL
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }
}