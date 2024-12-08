package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.designsystem.utils.getErrorAlertDialogParam
import com.bbcnewschallenge.core.domain.usecases.GetTopHeadlinesUseCase
import com.bbcnewschallenge.core.domain.usecases.SendAnalyticsUseCase
import com.bbcnewschallenge.core.router.di.qualifiers.NavGraphQualifier
import com.bbcnewschallenge.core.router.enums.NavGraph
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.ui.bases.BaseViewModel
import com.bbcnewschallenge.feature.home.analytics.home.HomeAnalytic
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    override val sendAnalyticsUseCase: SendAnalyticsUseCase,
    @NavGraphQualifier(NavGraph.MAIN) override val navigationManager: NavigationManager
) : BaseViewModel<HomeUiState>(HomeAnalytic, HomeUiState()), HomeCommandReceiver {

    override val commandReceiver = this

    override fun initUiState() {
        openScreenAnalytic()
        getArticles()
    }

    override fun navigateToHome2() {
    }

    override fun refresh() {
        getArticles()
    }

    private fun getArticles() = runAsyncTask(
        onError = ::handleRequestError,
        onStart = { updateUiState { it.setIsLoading(true) } },
        onCompletion = { updateUiState { it.setIsLoading(false) } },
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
            ).setArticles(emptyList())
        }
    }
}