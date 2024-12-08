package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.ui.interfaces.Command

internal sealed interface HomeCommand : Command<HomeCommandReceiver> {
    data class BiometryError(private val message: String) : HomeCommand {
        override fun execute(commandReceiver: HomeCommandReceiver) {
            commandReceiver.biometryError(message)
        }
    }

    data class NavigateToDetail(private val articleModel: ArticleModel) : HomeCommand {
        override fun execute(commandReceiver: HomeCommandReceiver) {
            commandReceiver.navigateToDetail(articleModel)
        }
    }

    data object BiometrySuccess : HomeCommand {
        override fun execute(commandReceiver: HomeCommandReceiver) {
            commandReceiver.biometrySuccess()
        }
    }

    data object Refresh : HomeCommand {
        override fun execute(commandReceiver: HomeCommandReceiver) {
            commandReceiver.refresh()
        }
    }
}