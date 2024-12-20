package com.bbcnewschallenge.core.designsystem.components.alertdialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.bbcnewschallenge.core.designsystem.components.buttons.Button
import com.bbcnewschallenge.core.designsystem.params.alertdialogs.ButtonAlertDialogParam
import com.bbcnewschallenge.core.designsystem.params.alertdialogs.DefaultAlertDialogParam
import com.bbcnewschallenge.core.designsystem.theme.BbcNewsChallengeTheme

@Composable
fun DefaultAlertDialog(param: DefaultAlertDialogParam) {
    AlertDialog(
        onDismissRequest = param.onDismiss?.onClick ?: {},
        icon = { Icon(painter = painterResource(param.iconId), contentDescription = null) },
        iconContentColor = MaterialTheme.colorScheme.error,
        title = { Text(text = stringResource(param.title)) },
        text = { Text(text = stringResource(param.text)) },
        dismissButton = param.onDismiss?.let {
            button(it)
        },
        confirmButton = {
            param.onConfirm?.let { button(it) }
        }
    )
}

private fun button(buttonParam: ButtonAlertDialogParam) = @Composable {
    Button(
        text = stringResource(buttonParam.textId),
        onClick = buttonParam.onClick
    )
}

@Composable
@Preview
private fun Preview() {
    BbcNewsChallengeTheme {
        DefaultAlertDialog(param = DefaultAlertDialogParam.getNetworkAlertDialogParam { })
    }
}