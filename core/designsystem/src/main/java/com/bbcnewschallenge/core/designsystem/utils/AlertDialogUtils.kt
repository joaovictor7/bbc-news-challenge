package com.bbcnewschallenge.core.designsystem.utils

import com.bbcnewschallenge.core.designsystem.params.alertdialogs.DefaultAlertDialogParam
import com.bbcnewschallenge.core.domain.errors.ApiError

fun getErrorAlertDialogParam(
    throwable: Throwable?,
    onDismiss: () -> Unit
) = throwable?.let {
    when (it) {
        is ApiError.Network -> DefaultAlertDialogParam.getNetworkAlertDialogParam(onDismiss)
        else -> DefaultAlertDialogParam.getGenericAlertDialogParam(onDismiss)
    }
}