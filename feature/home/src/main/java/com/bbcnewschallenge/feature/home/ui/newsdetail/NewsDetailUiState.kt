package com.bbcnewschallenge.feature.home.ui.newsdetail

import com.bbcnewschallenge.core.ui.interfaces.BaseUiState

internal data class NewsDetailUiState(
    val imageUrl: String? = null,
    val title: String = String(),
    val description: String? = null,
    val content: String? = null
) : BaseUiState {

}
