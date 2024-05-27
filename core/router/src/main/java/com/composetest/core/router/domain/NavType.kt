package com.composetest.core.router.domain

import androidx.navigation.NavType
import kotlin.reflect.KType

internal interface NavType {
    val navTypes: Map<KType, NavType<*>>
}