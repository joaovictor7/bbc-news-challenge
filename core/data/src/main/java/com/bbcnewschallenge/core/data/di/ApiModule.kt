package com.bbcnewschallenge.core.data.di

import com.bbcnewschallenge.common.extensions.source
import com.bbcnewschallenge.common.providers.BuildConfigProvider
import com.bbcnewschallenge.core.data.di.qualifiers.ApiQualifier
import com.bbcnewschallenge.core.data.enums.NetworkApi
import com.bbcnewschallenge.core.data.extensions.setHost
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {
    private const val API_KEY = "x-api-key"

    @Provides
    @Singleton
    @ApiQualifier(NetworkApi.NEWS_API)
    fun newsApi(
        httpClient: HttpClient,
        buildConfigProvider: BuildConfigProvider
    ): HttpClient = httpClient.setHost(
        host = buildConfigProvider.get.buildConfigFieldsModel.newsApiHost,
        networkApi = NetworkApi.NEWS_API,
        parameters = mapOf(buildConfigProvider.get.flavor.source),
        headers = mapOf(API_KEY to buildConfigProvider.get.buildConfigFieldsModel.newsApiKey)
    )
}