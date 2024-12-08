package com.bbcnewschallenge.feature.home.viewmodels

import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.domain.usecases.GetTopHeadlinesUseCase
import com.bbcnewschallenge.core.domain.usecases.SendAnalyticsUseCase
import com.bbcnewschallenge.core.router.destinations.home.NewsDetailDestination
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.security.providers.BiometricsProvider
import com.bbcnewschallenge.core.test.extensions.runFlowTest
import com.bbcnewschallenge.core.test.interfaces.CoroutinesTest
import com.bbcnewschallenge.feature.home.ui.home.HomeCommand
import com.bbcnewschallenge.feature.home.ui.home.HomeUiState
import com.bbcnewschallenge.feature.home.ui.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.TestDispatcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

private class HomeViewModelTest : CoroutinesTest {

    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase = mockk {
        coEvery { this@mockk.invoke() } returns articles
    }
    private val biometricsProvider: BiometricsProvider = mockk {
        every { isBiometricsAvailable } returns false
    }
    private val sendAnalyticsUseCase: SendAnalyticsUseCase = mockk(relaxed = true)
    private val navigationManager: NavigationManager = mockk(relaxed = true)

    private lateinit var viewModel: HomeViewModel

    override lateinit var testDispatcher: TestDispatcher


    @BeforeEach
    fun before() {
        viewModel = initViewModel()
    }

    @Test
    fun `initial uiState without biometric`() =
        runFlowTest(viewModel.uiState) { onCancelJob, collectedStates ->
            onCancelJob()

            assertEquals(
                listOf(
                    HomeUiState(),
                    HomeUiState(isLoading = true, showScreen = true),
                    HomeUiState(showScreen = true, articles = articles),
                ),
                collectedStates
            )
        }

    @Test
    fun `initial uiState with biometric is valid`() {
        coEvery { biometricsProvider.isBiometricsAvailable } returns true
        val viewModel = initViewModel()
        runFlowTest(viewModel.uiState) { onCancelJob, collectedStates ->
            viewModel.executeCommand(HomeCommand.BiometrySuccess)
            onCancelJob()

            assertEquals(
                listOf(
                    HomeUiState(),
                    HomeUiState(showBiometricPrompt = true),
                    HomeUiState(),
                    HomeUiState(showScreen = true, isLoading = true),
                    HomeUiState(showScreen = true, articles = articles),
                ),
                collectedStates
            )
        }
    }

    @Test
    fun `initial uiState with biometric isn't valid`() {
        coEvery { biometricsProvider.isBiometricsAvailable } returns true
        val viewModel = initViewModel()
        runFlowTest(viewModel.uiState) { onCancelJob, collectedStates ->
            viewModel.executeCommand(HomeCommand.BiometryError(String()))
            onCancelJob()

            assertEquals(
                listOf(
                    HomeUiState(),
                    HomeUiState(showBiometricPrompt = true),
                    HomeUiState(finishApp = true),
                ),
                collectedStates
            )
        }
    }

    @Test
    fun `navigate to detail`() = runFlowTest(viewModel.uiState) { onCancelJob, collectedStates ->
        viewModel.executeCommand(HomeCommand.NavigateToDetail(articles[0]))
        onCancelJob()

        assertEquals(
            listOf(
                HomeUiState(),
                HomeUiState(isLoading = true, showScreen = true),
                HomeUiState(showScreen = true, articles = articles),
            ),
            collectedStates
        )
        verify {
            navigationManager.navigate(
                NewsDetailDestination(
                    imageUrl = articles[0].urlToImage,
                    title = articles[0].title,
                    description = articles[0].description,
                    content = articles[0].content
                )
            )
        }
    }

    private fun initViewModel(getTopHeadlinesUseCase: GetTopHeadlinesUseCase = this.getTopHeadlinesUseCase) =
        HomeViewModel(
            getTopHeadlinesUseCase = getTopHeadlinesUseCase,
            biometricsProvider = biometricsProvider,
            sendAnalyticsUseCase = sendAnalyticsUseCase,
            navigationManager = navigationManager
        )

    private companion object {
        val articles = listOf(
            ArticleModel(
                provider = "Teste",
                title = "Teste",
                description = null,
                urlToImage = null,
                publishedAt = LocalDateTime.now(),
                content = null
            ),
            ArticleModel(
                provider = "Teste",
                title = "Teste",
                description = null,
                urlToImage = null,
                publishedAt = LocalDateTime.now(),
                content = null
            )
        )
    }
}