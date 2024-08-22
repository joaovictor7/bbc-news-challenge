package com.composetest.feature.configuration.ui.configuration

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.composetest.core.designsystem.theme.ComposeTestTheme
import com.composetest.core.ui.interfaces.Command
import com.composetest.core.ui.interfaces.Screen

internal object ConfigurationMenuScreen :
    Screen<ConfigurationMenuUiState, ConfigurationMenuCommandReceiver> {

    @Composable
    override operator fun invoke(
        uiState: ConfigurationMenuUiState,
        onExecuteCommand: (Command<ConfigurationMenuCommandReceiver>) -> Unit
    ) {
        Text(text = "Teste")
    }
}

@Composable
@Preview
private fun Preview() {
    ComposeTestTheme {
        ConfigurationMenuScreen(uiState = ConfigurationMenuUiState()) { }
    }
}