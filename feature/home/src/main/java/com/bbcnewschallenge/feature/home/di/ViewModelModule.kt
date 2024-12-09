package com.bbcnewschallenge.feature.home.di

import com.bbcnewschallenge.core.router.destinations.home.NewsDetailDestination
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {
    @Provides
    fun newsDetailDestination(): NewsDetailDestination? = null
}