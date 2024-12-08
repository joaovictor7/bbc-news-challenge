package com.bbcnewschallenge.feature.home.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bbcnewschallenge.core.designsystem.components.alertdialogs.DefaultAlertDialog
import com.bbcnewschallenge.core.designsystem.components.asyncimage.AsyncImage
import com.bbcnewschallenge.core.designsystem.constants.screenMargin
import com.bbcnewschallenge.core.designsystem.constants.topScreenMarginList
import com.bbcnewschallenge.core.designsystem.dimensions.spacings
import com.bbcnewschallenge.core.designsystem.extensions.horizontalScreenMargin
import com.bbcnewschallenge.core.designsystem.params.alertdialogs.DefaultAlertDialogParam
import com.bbcnewschallenge.core.designsystem.theme.BbcNewsChallengeTheme
import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.ui.interfaces.Command
import com.bbcnewschallenge.core.ui.interfaces.Screen
import java.time.LocalDateTime

internal object HomeScreen : Screen<HomeUiState, HomeCommandReceiver> {

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun invoke(
        uiState: HomeUiState,
        onExecuteCommand: (Command<HomeCommandReceiver>) -> Unit
    ) {
        val pullToRefreshState = rememberPullToRefreshState()
        LaunchedEffect(uiState.isLoading) {
            if (!uiState.isLoading) pullToRefreshState.animateToHidden()
        }
        PullToRefreshBox(
            modifier = Modifier.fillMaxSize(),
            state = pullToRefreshState,
            isRefreshing = uiState.isLoading,
            indicator = {
                Indicator(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .windowInsetsPadding(WindowInsets.statusBars),
                    isRefreshing = uiState.isLoading,
                    state = pullToRefreshState
                )
            },
            onRefresh = { onExecuteCommand(HomeCommand.Refresh) }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .horizontalScreenMargin(),
                contentPadding = topScreenMarginList,
                verticalArrangement = Arrangement.spacedBy(spacings.twelve)
            ) {
                items(uiState.articles) {
                    NewsCard(articleModel = it, onExecuteCommand = onExecuteCommand)
                }
                item {
                    Spacer(modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars))
                }
            }
        }
        AlertDialogHandler(uiState.alertDialogParam)
    }
}

@Composable
private fun NewsCard(
    articleModel: ArticleModel,
    onExecuteCommand: (Command<HomeCommandReceiver>) -> Unit
) {
    ElevatedCard(onClick = { onExecuteCommand(HomeCommand.NavigateToDetail(articleModel)) }) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            articleModel.urlToImage?.let {
                AsyncImage(
                    modifier = Modifier.sizeIn(maxHeight = 180.dp),
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
                text = articleModel.provider,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = articleModel.title,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
private fun AlertDialogHandler(defaultAlertDialogParam: DefaultAlertDialogParam?) =
    defaultAlertDialogParam?.let {
        DefaultAlertDialog(param = it)
    }

@Preview
@Composable
private fun Preview() {
    BbcNewsChallengeTheme {
        HomeScreen(
            uiState = HomeUiState(
                articles = listOf(
                    ArticleModel(
                        provider = "Teste",
                        title = "Teste",
                        description = "Teste",
                        urlToImage = "Teste",
                        publishedAt = LocalDateTime.now(),
                        content = "Teste"
                    )
                )
            )
        ) { }
    }
}