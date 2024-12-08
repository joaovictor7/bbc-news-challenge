package com.bbcnewschallenge.ui

import com.bbcnewschallenge.core.designsystem.extensions.systemBarStyles
import com.bbcnewschallenge.core.domain.models.AppThemeModel
import com.bbcnewschallenge.core.ui.interfaces.BaseUiState

data class MainUiState(
    val appTheme: AppThemeModel = AppThemeModel(),
    val showSplashScreen: Boolean = true,
) : BaseUiState {
    val statusBarStyle get() = appTheme.systemBarStyles.first
    val navigationBarStyle get() = appTheme.systemBarStyles.second

    fun setAppTheme(appTheme: AppThemeModel) = copy(appTheme = appTheme)
    fun splashScreenFinished() = copy(showSplashScreen = false)
}
