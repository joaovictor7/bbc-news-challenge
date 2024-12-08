package com.bbcnewschallenge.feature.home.ui.newsdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.bbcnewschallenge.core.designsystem.components.asyncimage.AsyncImage
import com.bbcnewschallenge.core.designsystem.components.toolbar.TopBarWithoutTitle
import com.bbcnewschallenge.core.designsystem.constants.screenMargin
import com.bbcnewschallenge.core.designsystem.dimensions.spacings
import com.bbcnewschallenge.core.designsystem.theme.BbcNewsChallengeTheme
import com.bbcnewschallenge.core.ui.interfaces.Command
import com.bbcnewschallenge.core.ui.interfaces.Screen

internal object NewsDetailScreen : Screen<NewsDetailUiState, NewsDetailCommandReceiver> {

    @Composable
    override fun invoke(
        uiState: NewsDetailUiState,
        onExecuteCommand: (Command<NewsDetailCommandReceiver>) -> Unit
    ) {
        Scaffold(topBar = { TopBarWithoutTitle() }) { paddingValues ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    uiState.imageUrl?.let {
                        AsyncImage(
                            url = it,
                            alignment = Alignment.TopCenter,
                            contentScale = ContentScale.None
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(screenMargin),
                    verticalArrangement = Arrangement.spacedBy(spacings.twelve)
                ) {
                    Text(
                        text = uiState.title,
                        style = MaterialTheme.typography.titleLarge
                    )
                    uiState.description?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    uiState.content?.let {
                        Text(
                            text = it,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    BbcNewsChallengeTheme {
        NewsDetailScreen(
            uiState = NewsDetailUiState()
        ) { }
    }
}