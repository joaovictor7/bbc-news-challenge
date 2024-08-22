package com.composetest.core.router.di

import androidx.lifecycle.SavedStateHandle
import com.composetest.common.di.qualifiers.Dispatcher
import com.composetest.common.enums.Dispatchers
import com.composetest.core.router.di.qualifiers.NavGraphQualifier
import com.composetest.core.router.enums.NavGraph
import com.composetest.core.router.managers.NavigationManager
import com.composetest.core.router.managers.NavigationManagerImpl
import com.composetest.core.router.providers.NavControllerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(ViewModelComponent::class)
internal object ManagerModule {

    @Provides
    @ViewModelScoped
    @NavGraphQualifier(NavGraph.MAIN)
    fun navigationMainManager(
        navControllerProvider: NavControllerProvider,
        savedStateHandle: SavedStateHandle,
        @Dispatcher(Dispatchers.Main) mainDispatcher: CoroutineDispatcher
    ): NavigationManager = NavigationManagerImpl(
        navControllerProvider = navControllerProvider,
        navGraph = NavGraph.MAIN,
        mainDispatcher = mainDispatcher,
        savedStateHandle = savedStateHandle
    )

//    @Provides
//    @ViewModelScoped
//    @NavGraphQualifier(NavGraph.ROOT)
//    fun navigationRootManager(
//        navControllerProvider: NavControllerProvider,
//        savedStateHandle: SavedStateHandle,
//        @Dispatcher(Dispatchers.Main) mainDispatcher: CoroutineDispatcher
//    ): NavigationManager = NavigationManagerImpl(
//        navControllerProvider = navControllerProvider,
//        navGraph = NavGraph.ROOT,
//        mainDispatcher = mainDispatcher,
//        savedStateHandle = savedStateHandle
//    )
}