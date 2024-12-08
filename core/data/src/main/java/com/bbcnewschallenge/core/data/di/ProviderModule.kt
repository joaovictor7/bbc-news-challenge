package com.bbcnewschallenge.core.data.di

import com.bbcnewschallenge.core.data.providers.FakeInstanceProvider
import com.bbcnewschallenge.core.data.providers.FakeInstanceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {

    @Binds
    abstract fun fakeInstanceProvider(
        fakeInstanceProviderImpl: FakeInstanceProviderImpl
    ): FakeInstanceProvider
}