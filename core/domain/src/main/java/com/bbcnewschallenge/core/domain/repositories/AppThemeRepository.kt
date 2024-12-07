package com.bbcnewschallenge.core.domain.repositories

import com.bbcnewschallenge.core.domain.enums.Theme
import com.bbcnewschallenge.core.domain.models.AppThemeModel
import kotlinx.coroutines.flow.Flow

interface AppThemeRepository {
    val customAppThemeFlow: Flow<Theme?>
    val appThemeFlow: Flow<AppThemeModel>

    suspend fun setTheme(theme: Theme)
    suspend fun setDynamicColor(dynamicColor: Boolean)
    suspend fun setCustomTheme(customTheme: Theme?)
}