package com.bbcnewschallenge.core.data.di

import com.bbcnewschallenge.core.data.repositories.AppThemeRepositoryImpl
import com.bbcnewschallenge.core.data.repositories.NewsApiRepositoryImpl
import com.bbcnewschallenge.core.data.repositories.SecretKeyRepositoryImpl
import com.bbcnewschallenge.core.domain.repositories.AppThemeRepository
import com.bbcnewschallenge.core.domain.repositories.NewsApiRepository
import com.bbcnewschallenge.core.domain.repositories.SecretKeyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    // Locals
    @Binds
    @Singleton
    abstract fun appThemeRepository(
        appThemeRepositoryImpl: AppThemeRepositoryImpl
    ): AppThemeRepository

    @Binds
    abstract fun secretKeyRepository(
        secretKeyRepositoryImpl: SecretKeyRepositoryImpl
    ): SecretKeyRepository

    // Remotes
    @Binds
    abstract fun newsApiRepository(
        newsApiRepositoryImpl: NewsApiRepositoryImpl
    ): NewsApiRepository
}