package com.bbcnewschallenge.core.security.di

import com.bbcnewschallenge.core.security.providers.CipherProvider
import com.bbcnewschallenge.core.security.providers.CipherProviderImpl
import com.bbcnewschallenge.core.security.providers.SqliteCipherProvider
import com.bbcnewschallenge.core.security.providers.SqliteCipherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {

    @Binds
    abstract fun cipherProvider(
        cipherProviderImpl: CipherProviderImpl
    ): CipherProvider

    @Binds
    abstract fun sqlCipherProvider(
        sqliteCipherProviderImpl: SqliteCipherProviderImpl
    ): SqliteCipherProvider
}