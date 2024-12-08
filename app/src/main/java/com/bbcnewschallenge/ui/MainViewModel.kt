package com.bbcnewschallenge.ui

import androidx.navigation.NavHostController
import com.bbcnewschallenge.core.domain.managers.AppThemeManager
import com.bbcnewschallenge.core.router.di.qualifiers.NavGraphQualifier
import com.bbcnewschallenge.core.router.enums.NavGraph
import com.bbcnewschallenge.core.router.managers.NavControllerManager
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.ui.bases.BaseViewModel
import com.bbcnewschallenge.ui.analytics.MainAnalytic
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appThemeManager: AppThemeManager,
    private val navControllerManager: NavControllerManager,
    @NavGraphQualifier(NavGraph.MAIN) override val navigationManager: NavigationManager
) : BaseViewModel<MainUiState>(MainAnalytic, MainUiState()), MainCommandReceiver {

    override val commandReceiver = this

    init {
        appThemeObservable()
    }

    override fun initUiState() {
        updateUiState { it.splashScreenFinished() }
    }


    override fun setMainNavGraph(navController: NavHostController) {
        navControllerManager.setNavController(NavGraph.MAIN, navController)
    }

    private fun appThemeObservable() {
        runFlowTask(flow = appThemeManager.appThemeFlow) { appTheme ->
            updateUiState { it.setAppTheme(appTheme) }
        }
    }
}