package com.bbcnewschallenge.feature.home.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bbcnewschallenge.core.designsystem.constants.screenMargin
import com.bbcnewschallenge.core.designsystem.extensions.horizontalScreenMargin
import com.bbcnewschallenge.core.designsystem.extensions.screenMargin
import com.bbcnewschallenge.core.designsystem.extensions.topScreenMargin
import com.bbcnewschallenge.core.designsystem.theme.ComposeTestTheme
import com.bbcnewschallenge.core.ui.interfaces.Command
import com.bbcnewschallenge.core.ui.interfaces.Screen

internal object HomeScreen : Screen<HomeUiState, HomeCommandReceiver> {

    @Composable
    override fun invoke(
        uiState: HomeUiState,
        onExecuteCommand: (Command<HomeCommandReceiver>) -> Unit
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().screenMargin(),
            contentPadding = PaddingValues(top = screenMargin)
        ) {
            item {
                Text(
                    text = "Home11111111111111111111",
                )
            }
            items(30) {
                Button(onClick = { onExecuteCommand(HomeCommand.NavigateToHome2) }) {
                    Text(text = "Go to Home 2")
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    ComposeTestTheme {
        HomeScreen(uiState = HomeUiState()) { }
    }
}