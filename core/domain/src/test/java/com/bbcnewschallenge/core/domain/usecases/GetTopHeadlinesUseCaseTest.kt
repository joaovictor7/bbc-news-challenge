package com.bbcnewschallenge.core.domain.usecases

import com.bbcnewschallenge.core.domain.errors.ApiError
import com.bbcnewschallenge.core.domain.models.ArticleModel
import com.bbcnewschallenge.core.domain.repositories.NewsApiRepository
import com.bbcnewschallenge.core.test.interfaces.CoroutinesTest
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDateTime

private class GetTopHeadlinesUseCaseTest : CoroutinesTest {

    private val newsApiRepository: NewsApiRepository = mockk()

    private lateinit var useCase: GetTopHeadlinesUseCase

    override lateinit var testDispatcher: TestDispatcher

    @BeforeEach
    fun before() {
        useCase = GetTopHeadlinesUseCase(newsApiRepository)
    }

    @Test
    fun `get articles success`() = runTest(testDispatcher) {
        coEvery { newsApiRepository.getTopHeadlinesNews() } returns articlesMock
        val articles = useCase()

        assertEquals(
            articles,
            listOf(articlesMock[1], articlesMock[2], articlesMock[0])
        )
    }

    @Test
    fun `get articles error`() = runTest(testDispatcher) {
        coEvery { newsApiRepository.getTopHeadlinesNews() } throws ApiError.Network()

        assertThrows<ApiError.Network> {
            useCase()
        }
    }

    private companion object {
        val articlesMock = listOf(
            ArticleModel(
                provider = "Teste",
                title = "Teste",
                description = null,
                urlToImage = null,
                publishedAt = LocalDateTime.now().plusDays(3),
                content = null
            ),
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
                publishedAt = LocalDateTime.now().plusDays(1),
                content = null
            ),
            ArticleModel(
                provider = "Teste",
                title = "removed",
                description = null,
                urlToImage = null,
                publishedAt = LocalDateTime.now(),
                content = null
            )
        )
    }
}