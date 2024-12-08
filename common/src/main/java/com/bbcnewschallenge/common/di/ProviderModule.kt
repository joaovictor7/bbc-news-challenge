package com.bbcnewschallenge.common.di

import com.bbcnewschallenge.common.providers.DispatcherProvider
import com.bbcnewschallenge.common.providers.DispatcherProviderImpl
import com.bbcnewschallenge.common.providers.NetworkProvider
import com.bbcnewschallenge.common.providers.NetworkProviderImpl
import com.bbcnewschallenge.common.providers.StringResourceProvider
import com.bbcnewschallenge.common.providers.StringResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {

    @Binds
    abstract fun dispatcherProvider(
        dispatcherProviderImpl: DispatcherProviderImpl
    ): DispatcherProvider

    @Binds
    abstract fun stringResourceProvider(
        stringResourceProviderImpl: StringResourceProviderImpl
    ): StringResourceProvider

    @Binds
    abstract fun networkProvider(networkProviderImpl: NetworkProviderImpl): NetworkProvider
}