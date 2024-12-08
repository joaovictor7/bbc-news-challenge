package com.bbcnewschallenge.ui

import androidx.navigation.NavHostController
import com.bbcnewschallenge.core.ui.interfaces.CommandReceiver

internal interface MainCommandReceiver : CommandReceiver<MainCommandReceiver> {
    fun setMainNavGraph(navController: NavHostController)
}