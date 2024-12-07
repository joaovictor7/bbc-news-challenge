package com.bbcnewschallenge.core.designsystem.utils

import com.bbcnewschallenge.core.designsystem.params.alertdialogs.DefaultAlertDialogParam
import com.bbcnewschallenge.core.domain.throwables.network.NetworkThrowable

fun getErrorAlertDialogParam(
    throwable: Throwable?,
    onDismiss: () -> Unit
) = throwable?.let {
    when (it) {
        is NetworkThrowable -> DefaultAlertDialogParam.getNetworkAlertDialogParam(onDismiss)
        else -> DefaultAlertDialogParam.getGenericAlertDialogParam(onDismiss)
    }
}