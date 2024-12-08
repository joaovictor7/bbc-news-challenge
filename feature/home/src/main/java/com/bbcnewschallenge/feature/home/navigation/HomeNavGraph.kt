package com.bbcnewschallenge.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import com.bbcnewschallenge.core.router.destinations.home.HomeDestination
import com.bbcnewschallenge.core.router.destinations.home.NewsDetailDestination
import com.bbcnewschallenge.core.ui.extensions.composable
import com.bbcnewschallenge.feature.home.ui.home.HomeCommandReceiver
import com.bbcnewschallenge.feature.home.ui.home.HomeScreen
import com.bbcnewschallenge.feature.home.ui.home.HomeUiState
import com.bbcnewschallenge.feature.home.ui.home.HomeViewModel
import com.bbcnewschallenge.feature.home.ui.newsdetail.NewsDetailCommandReceiver
import com.bbcnewschallenge.feature.home.ui.newsdetail.NewsDetailScreen
import com.bbcnewschallenge.feature.home.ui.newsdetail.NewsDetailUiState
import com.bbcnewschallenge.feature.home.ui.newsdetail.NewsDetailViewModel

fun NavGraphBuilder.homeNavGraph() {
    composable<HomeDestination, HomeViewModel, HomeUiState, HomeCommandReceiver>(
        screen = HomeScreen
    )
    composable<NewsDetailDestination, NewsDetailViewModel, NewsDetailUiState, NewsDetailCommandReceiver>(
        screen = NewsDetailScreen
    )
}