package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.ui.interfaces.BaseUiState

internal data class HomeUiState(
    val t: String = String(),
    val dockHeight: Int = 0
) : BaseUiState {
    fun setDockHeight(height: Int) = copy(dockHeight = height)
}
