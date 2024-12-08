package com.bbcnewschallenge.common.enums

enum class Flavor(val source: String) {
    BBC_NEWS("bbc-news"), BBC_SPORT("bbc-sport");

    override fun toString() = name.lowercase()

    companion object {
        fun String.getFlavor() = entries.find { it.toString() == this } ?: BBC_NEWS
    }
}