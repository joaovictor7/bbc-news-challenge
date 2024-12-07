package com.bbcnewschallenge.core.designsystem.dimensions

import androidx.compose.runtime.Composable
import com.bbcnewschallenge.core.designsystem.dimensions.densities.defaults.Component
import com.bbcnewschallenge.core.designsystem.dimensions.densities.defaults.FontSize
import com.bbcnewschallenge.core.designsystem.dimensions.densities.defaults.Spacing
import com.bbcnewschallenge.core.designsystem.dimensions.densities.dp1200.Component1200Dp
import com.bbcnewschallenge.core.designsystem.dimensions.densities.dp1200.FontSize1200Dp
import com.bbcnewschallenge.core.designsystem.dimensions.densities.dp1200.Spacing1200Dp
import com.bbcnewschallenge.core.designsystem.dimensions.densities.dp840.Component840Dp
import com.bbcnewschallenge.core.designsystem.utils.getDensity

internal val components: Component
    @Composable get() = getDensity(
        default = Component(),
        dp840 = Component840Dp(),
        dp1200 = Component1200Dp()
    )

val spacings: Spacing
    @Composable get() = getDensity(
        default = Spacing(),
        dp1200 = Spacing1200Dp(),
    )

val fontSizes: FontSize
    @Composable get() = getDensity(
        default = FontSize(),
        dp1200 = FontSize1200Dp(),
    )