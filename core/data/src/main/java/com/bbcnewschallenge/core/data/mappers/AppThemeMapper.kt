package com.bbcnewschallenge.core.data.mappers

import com.bbcnewschallenge.common.extensions.orFalse
import com.bbcnewschallenge.core.domain.enums.Theme
import com.bbcnewschallenge.core.domain.models.AppThemeModel
import javax.inject.Inject

internal class AppThemeMapper @Inject constructor() {

    operator fun invoke(
        theme: String?,
        dynamicColor: Boolean?
    ) = AppThemeModel(
        theme = Theme.getThemeByName(theme),
        dynamicColors = dynamicColor.orFalse
    )
}