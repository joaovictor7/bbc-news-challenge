package com.bbcnewschallenge.feature.home.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bbcnewschallenge.core.designsystem.theme.ComposeTestTheme
import com.bbcnewschallenge.core.ui.interfaces.Command
import com.bbcnewschallenge.core.ui.interfaces.Screen

internal object HomeScreen : Screen<HomeUiState, HomeCommandReceiver> {

    @Composable
    @OptIn(ExperimentalFoundationApi::class)
    override fun invoke(
        uiState: HomeUiState,
        onExecuteCommand: (Command<HomeCommandReceiver>) -> Unit
    ) {
        LazyColumn {
            stickyHeader {

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