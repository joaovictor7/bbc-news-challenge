package com.bbcnewschallenge.core.designsystem.params.dock

import androidx.annotation.DrawableRes

data class IconDockParam(
    val index: Int,
    @DrawableRes val iconId: Int,
    val contentDescription: String? = null
)
