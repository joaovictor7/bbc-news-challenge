package com.composetest.feature.home.ui

sealed class HomeAction {
    data object ReturnLogin: HomeAction()
}