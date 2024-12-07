package com.bbcnewschallenge.core.data.datasources.remote

import com.bbcnewschallenge.core.data.network.responses.NewsApiResponse

internal interface NewsApiDataSource {
    suspend fun getTopHeadlinesNews(): NewsApiResponse
}