package com.bbcnewschallenge.feature.home.ui.newsdetail

import com.bbcnewschallenge.core.router.destinations.home.NewsDetailDestination
import com.bbcnewschallenge.core.router.di.qualifiers.NavGraphQualifier
import com.bbcnewschallenge.core.router.enums.NavGraph
import com.bbcnewschallenge.core.router.extensions.getParam
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.ui.bases.BaseViewModel
import com.bbcnewschallenge.feature.home.analytics.newsdetail.NewsDetailScreenAnalytic
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class NewsDetailViewModel @Inject constructor(
    destination: NewsDetailDestination? = null,
    @NavGraphQualifier(NavGraph.MAIN) override val navigationManager: NavigationManager
) : BaseViewModel<NewsDetailUiState>(NewsDetailScreenAnalytic, NewsDetailUiState()),
    NewsDetailCommandReceiver {

    private val destination = destination ?: navigationManager.getParam<NewsDetailDestination>()

    override val commandReceiver = this

    override fun initUiState() {
        updateUiState {
            it.copy(
                imageUrl = destination.imageUrl,
                title = destination.title,
                description = destination.description,
                content = destination.content
            )
        }
    }
}