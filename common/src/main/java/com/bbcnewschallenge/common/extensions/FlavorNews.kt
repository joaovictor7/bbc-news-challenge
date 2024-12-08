package com.bbcnewschallenge.common.extensions

import com.bbcnewschallenge.common.enums.Flavor

private const val SOURCES = "sources"
private const val COUNTRY = "country"

val Flavor.source get() = when(this) {
    Flavor.BBC_NEWS -> SOURCES to "bbc-news"
    Flavor.BBC_SPORT -> SOURCES to "bbc-sport"
    Flavor.ALL_NEWS -> COUNTRY to "us"
}