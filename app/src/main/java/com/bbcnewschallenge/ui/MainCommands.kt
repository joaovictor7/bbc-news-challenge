package com.bbcnewschallenge.ui

import androidx.navigation.NavHostController
import com.bbcnewschallenge.core.ui.interfaces.Command

internal sealed interface MainCommand : Command<MainCommandReceiver> {
    data object FetchRemoteConfig : MainCommand {
        override fun execute(commandReceiver: MainCommandReceiver) {
            commandReceiver.fetchRemoteConfig()
        }
    }

    data class SetNavigationGraph(private val navController: NavHostController) : MainCommand {
        override fun execute(commandReceiver: MainCommandReceiver) {
            commandReceiver.setMainNavGraph(navController)
        }
    }
}