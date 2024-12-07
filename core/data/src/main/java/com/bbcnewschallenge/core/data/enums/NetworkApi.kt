package com.bbcnewschallenge.core.data.enums

import io.ktor.http.URLProtocol

internal enum class NetworkApi(val protocol: URLProtocol = URLProtocol.HTTPS) {
    NEWS_API
}