package com.bbcnewschallenge.core.router.managers

import androidx.lifecycle.SavedStateHandle
import com.bbcnewschallenge.core.router.enums.NavigationMode
import com.bbcnewschallenge.core.router.interfaces.Destination
import com.bbcnewschallenge.core.router.interfaces.ResultParam
import kotlinx.coroutines.flow.Flow
import kotlin.reflect.KClass

interface NavigationManager {
    val savedStateHandle: SavedStateHandle
    val currentRoute: String?
    val currentRouteChangesFlow: Flow<String?>

    fun <D : Destination> navigate(
        destination: D,
        navigationMode: NavigationMode? = null
    )

    fun navigateBack()
    fun <Result : ResultParam> navigateBack(result: Result)
    suspend fun <D : Destination> asyncNavigate(
        destination: D,
        navigationMode: NavigationMode? = null
    )

    suspend fun asyncNavigateBack()
    suspend fun <Result : ResultParam> asyncNavigateBack(result: Result)
    fun <Result : ResultParam> getResultFlow(resultClass: KClass<Result>): Flow<Result>
}