package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.ui.interfaces.Command

internal sealed interface HomeCommand : Command<HomeCommandReceiver> {
    data object NavigateToHome2 : HomeCommand {
        override fun execute(commandReceiver: HomeCommandReceiver) {
            commandReceiver.navigateToHome2()
        }
    }
}