package com.composetest.feature.home.ui.home3

import com.composetest.core.ui.interfaces.Command
import com.composetest.core.ui.interfaces.CommandReceiver

internal interface Home3CommandReceiver : CommandReceiver<Home3CommandReceiver> {

    override fun executeCommand(command: Command<Home3CommandReceiver>) {
        command.execute(this)
    }

    fun returnLogin()
}