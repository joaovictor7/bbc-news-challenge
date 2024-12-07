package com.bbcnewschallenge.core.data.datasources.local

import com.bbcnewschallenge.core.domain.enums.Theme
import kotlinx.coroutines.flow.SharedFlow

internal interface AppThemeDataSource {
    val customAppThemeFlow: SharedFlow<Theme?>

    suspend fun emitCustomAppTheme(theme: Theme?)
}