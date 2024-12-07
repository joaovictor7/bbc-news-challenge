package com.bbcnewschallenge.core.router.interfaces

interface Destination {
    val asRoute get() = this::class.qualifiedName
}