package com.bbcnewschallenge.core.data.extensions

import com.bbcnewschallenge.core.data.enums.NetworkApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpSend
import io.ktor.client.plugins.plugin
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post

internal fun HttpClient.setHost(
    host: String,
    port: Int = 0,
    networkApi: NetworkApi,
    parameters: Map<String, String> = emptyMap(),
    headers: Map<String, String> = emptyMap()
) = apply {
    plugin(HttpSend).intercept { request ->
        request.url {
            this.host = host
            this.port = port
            this.protocol = networkApi.protocol
            parameters.forEach {
                this.parameters.append(it.key, it.value)
            }
        }
        request.headers {
            headers.forEach {
                append(it.key, it.value)
            }
        }
        execute(request)
    }
}

internal suspend inline fun <reified Response> HttpClient.post(
    url: String,
    request: HttpRequestBuilder.() -> Unit
) = post(url, request).body<Response>()

internal suspend inline fun <reified Response> HttpClient.get(
    url: String,
    request: HttpRequestBuilder.() -> Unit = {}
) = get(url, request).body<Response>()