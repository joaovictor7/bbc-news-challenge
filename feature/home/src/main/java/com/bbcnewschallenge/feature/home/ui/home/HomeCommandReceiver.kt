package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.ui.interfaces.CommandReceiver

internal interface HomeCommandReceiver : CommandReceiver<HomeCommandReceiver> {
    fun biometrySuccess()
    fun biometryError(message: String)
    fun navigateToDetail(article: ArticleModel)
    fun refresh()
}