package com.bbcnewschallenge.core.designsystem.params.alertdialogs

import androidx.annotation.StringRes

data class ButtonAlertDialogParam(
    @StringRes val textId: Int,
    val onClick: () -> Unit
)
