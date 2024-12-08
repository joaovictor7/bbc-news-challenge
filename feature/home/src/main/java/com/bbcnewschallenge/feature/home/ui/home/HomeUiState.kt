package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.designsystem.params.alertdialogs.DefaultAlertDialogParam
import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.ui.interfaces.BaseUiState

internal data class HomeUiState(
    val articles: List<ArticleModel> = emptyList(),
    val alertDialogParam: DefaultAlertDialogParam? = null,
    override val isLoading: Boolean = false
) : BaseUiState {
    fun setIsLoading(isLoading: Boolean): HomeUiState {
        return copy(isLoading = isLoading)
    }
    fun setArticles(articles: List<ArticleModel>) = copy(articles = articles)
    fun setAlertDialogParam(param: DefaultAlertDialogParam?) = copy(alertDialogParam = param)
}
