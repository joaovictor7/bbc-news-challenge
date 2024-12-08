package com.bbcnewschallenge.common.enums

enum class Flavor {
    BBC_NEWS, BBC_SPORT, ALL_NEWS;

    override fun toString() = name.lowercase()

    companion object {
        fun String.getFlavor() = entries.find { it.toString() == this } ?: BBC_NEWS
    }
}