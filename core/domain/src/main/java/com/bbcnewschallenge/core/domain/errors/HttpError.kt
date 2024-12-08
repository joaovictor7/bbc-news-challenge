package com.bbcnewschallenge.core.domain.errors

sealed class HttpError : Throwable() {

    data class Request(override val message: String) : HttpError()

    data class Unknown(override val message: String?) : HttpError()

    class Unauthorized : HttpError() {
        override val message = "Client not authorized"
    }

    class Network : HttpError() {
        override val message = "No internet connection"
    }
}