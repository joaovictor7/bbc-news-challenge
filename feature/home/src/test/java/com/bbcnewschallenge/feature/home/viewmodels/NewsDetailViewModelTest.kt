package com.bbcnewschallenge.feature.home.viewmodels

import com.bbcnewschallenge.core.router.destinations.home.NewsDetailDestination
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.test.extensions.runFlowTest
import com.bbcnewschallenge.core.test.interfaces.CoroutinesTest
import com.bbcnewschallenge.feature.home.ui.newsdetail.NewsDetailUiState
import com.bbcnewschallenge.feature.home.ui.newsdetail.NewsDetailViewModel
import io.mockk.mockk
import kotlinx.coroutines.test.TestDispatcher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

private class NewsDetailViewModelTest : CoroutinesTest {
    private val navigationManager: NavigationManager = mockk(relaxed = true)

    private lateinit var viewModel: NewsDetailViewModel

    override lateinit var testDispatcher: TestDispatcher

    @BeforeEach
    fun before() {
        viewModel = initViewModel()
    }

    @Test
    fun `initial uiState`() =
        runFlowTest(viewModel.uiState) { onCancelJob, collectedStates ->
            onCancelJob()

            assertEquals(
                listOf(
                    NewsDetailUiState(),
                    NewsDetailUiState(
                        title = destination.title,
                        description = destination.description,
                        imageUrl = destination.imageUrl,
                        content = destination.content
                    ),
                ),
                collectedStates
            )
        }

    private fun initViewModel() =
        NewsDetailViewModel(
            navigationManager = navigationManager,
            destination = destination
        )

    private companion object {
        val destination = NewsDetailDestination(
            title = "Teste",
            description = "Teste",
            imageUrl = null,
            content = "Teste"
        )
    }
}