package com.bbcnewschallenge.core.domain.models

import java.time.LocalDateTime

data class ArticleModel(
    val providerName: String,
    val title: String,
    val description: String?,
    val urlToImage: String?,
    val publishedAt: LocalDateTime,
    val content: String?
)
