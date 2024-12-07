package com.bbcnewschallenge.core.data.repositories

import com.bbcnewschallenge.core.data.datasources.remote.NewsApiDataSource
import com.bbcnewschallenge.core.data.mappers.ArticleMapper
import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.domain.repositories.NewsApiRepository
import javax.inject.Inject

internal class NewsApiRepositoryImpl @Inject constructor(
    private val newsApiDataSource: NewsApiDataSource,
    private val articleMapper: ArticleMapper
) : NewsApiRepository {

    override suspend fun getTopHeadlinesNews(): List<ArticleModel> {
        val response = newsApiDataSource.getTopHeadlinesNews()
        return articleMapper(response)
    }
}