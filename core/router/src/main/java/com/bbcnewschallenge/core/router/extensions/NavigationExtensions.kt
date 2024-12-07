package com.bbcnewschallenge.core.router.extensions

import androidx.navigation.toRoute
import com.bbcnewschallenge.core.router.interfaces.Destination
import com.bbcnewschallenge.core.router.managers.NavigationManager
import com.bbcnewschallenge.core.router.utils.getNavTypes

inline fun <reified D : Destination> NavigationManager.getParam() =
    savedStateHandle.toRoute<D>(getNavTypes<D>())