package com.bbcnewschallenge.core.designsystem.extensions

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.bbcnewschallenge.core.domain.enums.Theme

val Theme.isDarkMode
    @Composable get() = when (this) {
        Theme.AUTO -> isSystemInDarkTheme()
        else -> this == Theme.DARK
    }