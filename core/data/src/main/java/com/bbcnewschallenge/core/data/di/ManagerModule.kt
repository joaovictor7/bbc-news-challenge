package com.bbcnewschallenge.core.data.di

import com.bbcnewschallenge.core.data.managers.AppThemeManagerImpl
import com.bbcnewschallenge.core.data.managers.RemoteConfigManagerImpl
import com.bbcnewschallenge.core.data.providers.WorkManagerProvider
import com.bbcnewschallenge.core.data.providers.WorkManagerProviderImpl
import com.bbcnewschallenge.core.domain.managers.AppThemeManager
import com.bbcnewschallenge.core.domain.managers.RemoteConfigManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ManagerModule {
    @Binds
    abstract fun appThemeManager(appThemeManagerImpl: AppThemeManagerImpl): AppThemeManager

    @Binds
    abstract fun workManager(workManagerImpl: WorkManagerProviderImpl): WorkManagerProvider

    @Binds
    abstract fun remoteConfigManager(remoteConfigManagerImpl: RemoteConfigManagerImpl): RemoteConfigManager
}