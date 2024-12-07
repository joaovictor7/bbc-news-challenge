package com.bbcnewschallenge.core.domain.repositories

import com.bbcnewschallenge.core.domain.models.ArticleModel

interface NewsApiRepository {
    suspend fun getTopHeadlinesNews(): List<ArticleModel>
}