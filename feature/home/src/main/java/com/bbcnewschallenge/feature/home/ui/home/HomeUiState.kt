package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.designsystem.params.alertdialogs.DefaultAlertDialogParam
import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.ui.interfaces.BaseUiState

internal data class HomeUiState(
    val showScreen: Boolean = false,
    val showBiometricPrompt: Boolean = false,
    val articles: List<ArticleModel> = emptyList(),
    val alertDialogParam: DefaultAlertDialogParam? = null,
    val finishApp: Boolean = false,
    override val isLoading: Boolean = false
) : BaseUiState {
    fun setIsLoading(isLoading: Boolean) = copy(isLoading = isLoading, showScreen = if (isLoading) true else showScreen)
    fun setArticles(articles: List<ArticleModel>) = copy(articles = articles)
    fun setAlertDialogParam(param: DefaultAlertDialogParam?) = copy(alertDialogParam = param)
    fun setShowBiometricPrompt(show: Boolean) = copy(showBiometricPrompt = show)
    fun setFinishApp(finish: Boolean) = copy(finishApp = finish)
}
