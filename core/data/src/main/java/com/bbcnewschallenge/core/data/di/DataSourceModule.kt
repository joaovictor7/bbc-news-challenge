package com.bbcnewschallenge.core.data.di

import com.bbcnewschallenge.core.data.datasources.local.AppThemeDataSource
import com.bbcnewschallenge.core.data.datasources.local.AppThemeDataSourceImpl
import com.bbcnewschallenge.core.data.datasources.local.PreferenceDataSource
import com.bbcnewschallenge.core.data.datasources.local.PreferenceDataSourceImpl
import com.bbcnewschallenge.core.data.datasources.remote.NewsApiDataSource
import com.bbcnewschallenge.core.data.datasources.remote.NewsApiDataSourceImpl
import com.bbcnewschallenge.core.data.datasources.remote.NewsApiFakeDataSourceImpl
import com.bbcnewschallenge.core.data.di.qualifiers.ApiQualifier
import com.bbcnewschallenge.core.data.enums.NetworkApi
import com.bbcnewschallenge.core.data.providers.FakeInstanceProvider
import com.bbcnewschallenge.core.data.utils.RemoteCallUtils
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceBindsModule {

    @Binds
    abstract fun preferenceDataSource(
        preferenceDataSourceImpl: PreferenceDataSourceImpl
    ): PreferenceDataSource

    @Binds
    abstract fun appThemeDataSource(appThemeDataSourceImpl: AppThemeDataSourceImpl): AppThemeDataSource
}

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceProvidesModule {

    @Provides
    fun authenticationDataSource(
        fakeInstanceProvider: FakeInstanceProvider,
        @ApiQualifier(NetworkApi.NEWS_API) newsApi: HttpClient,
        remoteCallUtils: RemoteCallUtils
    ): NewsApiDataSource = fakeInstanceProvider.getInstance(
        instance = NewsApiDataSourceImpl(
            requestUtils = remoteCallUtils,
            newsApi = newsApi
        ),
        fakeInstance = NewsApiFakeDataSourceImpl(
            requestUtils = remoteCallUtils
        )
    )
}