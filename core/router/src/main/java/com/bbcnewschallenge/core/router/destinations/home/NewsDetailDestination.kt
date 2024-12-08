package com.bbcnewschallenge.core.router.destinations.home

import com.bbcnewschallenge.core.router.interfaces.Destination
import kotlinx.serialization.Serializable

@Serializable
data class NewsDetailDestination(
    val imageUrl: String?,
    val title: String,
    val description: String?,
    val content: String?
) : Destination
