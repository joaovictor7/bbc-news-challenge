package com.composetest.core.database.di

import com.composetest.core.database.repositories.SessionRepository
import com.composetest.core.database.repositories.SessionRepositoryImpl
import com.composetest.core.database.repositories.UserRepository
import com.composetest.core.database.repositories.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryBindsModule {
    @Binds
    abstract fun sessionRepository(sessionRepositoryImpl: SessionRepositoryImpl): SessionRepository

    @Binds
    abstract fun userRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}
