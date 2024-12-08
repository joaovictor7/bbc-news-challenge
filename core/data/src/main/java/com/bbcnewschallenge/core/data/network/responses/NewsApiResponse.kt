package com.bbcnewschallenge.core.data.network.responses

import kotlinx.serialization.Serializable

@Serializable
internal data class NewsApiResponse(
    val articles: List<ArticleResponse>,
)