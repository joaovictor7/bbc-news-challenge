package com.bbcnewschallenge.core.data.repositories

import com.bbcnewschallenge.core.data.constants.PreferencesDataKeys
import com.bbcnewschallenge.core.data.datasources.local.AppThemeDataSource
import com.bbcnewschallenge.core.data.datasources.local.PreferenceDataSource
import com.bbcnewschallenge.core.data.mappers.AppThemeMapper
import com.bbcnewschallenge.core.domain.enums.Theme
import com.bbcnewschallenge.core.domain.models.AppThemeModel
import com.bbcnewschallenge.core.domain.repositories.AppThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class AppThemeRepositoryImpl @Inject constructor(
    private val preferenceDataSource: PreferenceDataSource,
    private val appThemeDataSource: AppThemeDataSource,
    private val appThemeMapper: AppThemeMapper,
) : AppThemeRepository {

    override val customAppThemeFlow: Flow<Theme?>
        get() = appThemeDataSource.customAppThemeFlow

    override val appThemeFlow: Flow<AppThemeModel> get() = preferenceDataSource.getData { preferences ->
        val theme = preferences[PreferencesDataKeys.appTheme]
        val dynamicColors = preferences[PreferencesDataKeys.dynamicColor]
        appThemeMapper(theme, dynamicColors)
    }

    override suspend fun setTheme(theme: Theme) {
        preferenceDataSource.setData(PreferencesDataKeys.appTheme, theme.name)
    }

    override suspend fun setDynamicColor(dynamicColor: Boolean) {
        preferenceDataSource.setData(PreferencesDataKeys.dynamicColor, dynamicColor)
    }

    override suspend fun setCustomTheme(customTheme: Theme?) {
        appThemeDataSource.emitCustomAppTheme(customTheme)
    }
}