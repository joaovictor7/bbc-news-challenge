package com.bbcnewschallenge.core.data.managers

import com.bbcnewschallenge.core.domain.enums.Theme
import com.bbcnewschallenge.core.domain.managers.AppThemeManager
import com.bbcnewschallenge.core.domain.repositories.AppThemeRepository
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

internal class AppThemeManagerImpl @Inject constructor(
    private val appThemeRepository: AppThemeRepository
) : AppThemeManager {

    override val appThemeFlow
        get() = appThemeRepository
            .appThemeFlow
            .combine(appThemeRepository.customAppThemeFlow) { appTheme, customTheme ->
                appTheme.copy(customTheme = customTheme)
            }

    override suspend fun setTheme(theme: Theme) = appThemeRepository.setTheme(theme)

    override suspend fun setDynamicColor(dynamicColor: Boolean) =
        appThemeRepository.setDynamicColor(dynamicColor)

    override suspend fun setCustomTheme(customTheme: Theme?) =
        appThemeRepository.setCustomTheme(customTheme)

    override suspend fun getAppTheme() = appThemeFlow.firstOrNull()
}