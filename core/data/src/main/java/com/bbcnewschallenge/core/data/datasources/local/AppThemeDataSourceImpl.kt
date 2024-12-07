package com.bbcnewschallenge.core.data.datasources.local

import com.bbcnewschallenge.core.domain.enums.Theme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

internal class AppThemeDataSourceImpl @Inject constructor() : AppThemeDataSource {

    private val _customAppThemeFlow = MutableStateFlow<Theme?>(null)
    override val customAppThemeFlow = _customAppThemeFlow

    override suspend fun emitCustomAppTheme(theme: Theme?) {
        _customAppThemeFlow.update { theme }
    }
}