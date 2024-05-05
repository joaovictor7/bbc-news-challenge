package com.composetest.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.composetest.core.ui.utils.SetStatusBarAppearance

@Composable
fun ComposeTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = getColorScheme(dynamicColor, darkTheme)
    SetStatusBarAppearance(isDarkMode = darkTheme)
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = {
            Surface(content = content)
        }
    )
}

@Composable
private fun getColorScheme(dynamicColor: Boolean, darkTheme: Boolean) = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }
    darkTheme -> darkColorScheme
    else -> lightColorScheme
}