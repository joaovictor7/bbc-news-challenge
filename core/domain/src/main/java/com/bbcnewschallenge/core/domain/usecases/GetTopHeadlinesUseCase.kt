package com.bbcnewschallenge.core.domain.usecases

import com.bbcnewschallenge.core.domain.repositories.NewsApiRepository
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(
    private val repository: NewsApiRepository
) {
    suspend operator fun invoke() = repository.getTopHeadlinesNews()
}