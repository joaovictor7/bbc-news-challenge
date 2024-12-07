package com.bbcnewschallenge.core.domain.models

import com.bbcnewschallenge.core.domain.enums.Theme

data class AppThemeModel(
    val theme: Theme = Theme.AUTO,
    val dynamicColors: Boolean = false,
    val customTheme: Theme? = null
)