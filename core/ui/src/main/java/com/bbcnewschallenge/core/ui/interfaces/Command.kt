package com.bbcnewschallenge.core.ui.interfaces

interface Command<CommandReceiver> {
    fun execute(commandReceiver: CommandReceiver)
}