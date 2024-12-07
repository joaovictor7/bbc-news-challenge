package com.bbcnewschallenge.di

import com.bbcnewschallenge.common.providers.BuildConfigProvider
import com.bbcnewschallenge.providers.BuildConfigProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {
    @Binds
    abstract fun buildConfigProvider(buildConfigProviderImpl: BuildConfigProviderImpl): BuildConfigProvider
}