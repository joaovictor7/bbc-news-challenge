package com.bbcnewschallenge.core.router.managers

import androidx.navigation.NavHostController
import com.bbcnewschallenge.core.router.enums.NavGraph
import javax.inject.Inject
import kotlin.collections.set

internal class NavControllerManagerImpl @Inject constructor() : NavControllerManager {

    private val navControllers: MutableMap<NavGraph, NavHostController> = mutableMapOf()

    override fun setNavController(
        navGraph: NavGraph,
        navController: NavHostController
    ) {
        navControllers[navGraph] = navController
    }

    override fun getNavController(navGraph: NavGraph) = navControllers.getValue(navGraph)
}