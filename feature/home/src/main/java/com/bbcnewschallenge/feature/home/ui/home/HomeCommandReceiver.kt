package com.bbcnewschallenge.feature.home.ui.home

import com.bbcnewschallenge.core.ui.interfaces.CommandReceiver

internal interface HomeCommandReceiver : CommandReceiver<HomeCommandReceiver> {
    fun navigateToHome2()
}