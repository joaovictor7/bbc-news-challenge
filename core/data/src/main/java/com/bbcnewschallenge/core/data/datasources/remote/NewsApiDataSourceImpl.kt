package com.bbcnewschallenge.core.data.datasources.remote

import com.bbcnewschallenge.core.data.di.qualifiers.ApiQualifier
import com.bbcnewschallenge.core.data.enums.NetworkApi
import com.bbcnewschallenge.core.data.extensions.get
import com.bbcnewschallenge.core.data.network.responses.NewsApiResponse
import com.bbcnewschallenge.core.data.utils.RemoteCallUtils
import io.ktor.client.HttpClient

internal class NewsApiDataSourceImpl(
    private val requestUtils: RemoteCallUtils,
    @ApiQualifier(NetworkApi.NEWS_API) private val newsApi: HttpClient
) : NewsApiDataSource {

    override suspend fun getTopHeadlinesNews() = requestUtils.executeRemoteCall {
        newsApi.get<NewsApiResponse>(TOP_HEADLINE_PATH)
    }

    private companion object {
        const val TOP_HEADLINE_PATH = "top-headlines"
    }
}