package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.designsystem.utils.getErrorAlertDialogParam
import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.domain.usecases.GetTopHeadlinesUseCase
import com.bbcnewschallenge.core.router.destinations.home.NewsDetailDestination
import com.bbcnewschallenge.core.router.di.qualifiers.NavGraphQualifier
import com.bbcnewschallenge.core.router.enums.NavGraph
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.security.providers.BiometricsProvider
import com.bbcnewschallenge.core.ui.bases.BaseViewModel
import com.bbcnewschallenge.feature.home.analytics.home.HomeScreenAnalytic
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    private val biometricsProvider: BiometricsProvider,
    @NavGraphQualifier(NavGraph.MAIN) override val navigationManager: NavigationManager
) : BaseViewModel<HomeUiState>(HomeScreenAnalytic, HomeUiState()), HomeCommandReceiver {

    override val commandReceiver = this

    override fun initUiState() {
        checkBiometrics()
    }

    override fun biometrySuccess() {
        updateUiState { it.setShowBiometricPrompt(false) }
        getArticles()
    }

    override fun biometryError(message: String) {
        updateUiState { it.setFinishApp(true) }
    }

    override fun navigateToDetail(article: ArticleModel) {
        navigationManager.navigate(
            NewsDetailDestination(
                imageUrl = article.urlToImage,
                title = article.title,
                description = article.description,
                content = article.content
            )
        )
    }

    override fun refresh() {
        getArticles()
    }

    private fun checkBiometrics() {
        if (biometricsProvider.isBiometricsAvailable) {
            updateUiState { it.copy(showBiometricPrompt = true) }
        } else {
            getArticles()
        }
    }

    private fun getArticles() = runAsyncTask(
        onError = ::handleRequestError,
        onStart = { updateUiState { it.setIsLoading(true) } },
    ) {
        val articles = getTopHeadlinesUseCase()
        updateUiState {
            it.setArticles(articles)
        }
    }

    private fun handleRequestError(error: Throwable) {
        updateUiState { uiState ->
            uiState.setAlertDialogParam(
                getErrorAlertDialogParam(error) {
                    updateUiState { it.setAlertDialogParam(null) }
                }
            )
        }
    }
}