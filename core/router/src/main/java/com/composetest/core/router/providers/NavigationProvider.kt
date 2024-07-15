package com.composetest.core.router.providers

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import com.composetest.core.router.interfaces.ResultParam
import kotlinx.coroutines.flow.Flow

interface NavigationProvider {

    val savedStateHandle: SavedStateHandle
    val currentBackStackEntryFlow: Flow<NavBackStackEntry>

    fun currentDestinationCheck(destination: Any): Boolean
    fun <Destination : Any> navigate(destination: Destination, removeCurrentScreen: Boolean = false)
    fun <Destination : Any> navigateRemovePrevious(destination: Destination)
    fun navigateBack()
    fun <Result : ResultParam> navigateBack(result: Result)
    suspend fun <Destination : Any> asyncNavigate(
        destination: Destination,
        removeCurrentScreen: Boolean = false
    )
    suspend fun <Destination : Any> asyncNavigateRemovePrevious(destination: Destination)
    suspend fun asyncNavigateBack()
    suspend fun <Result : ResultParam> asyncNavigateBack(result: Result)
}