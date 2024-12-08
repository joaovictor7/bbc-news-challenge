package com.bbcnewschallenge.core.designsystem.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bbcnewschallenge.core.designsystem.extensions.opacity
import com.bbcnewschallenge.core.designsystem.theme.BbcNewsChallengeTheme

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = BorderStroke(
            width = ButtonDefaults.outlinedButtonBorder().width,
            color = if (enabled)
                MaterialTheme.colorScheme.outline
            else
                MaterialTheme.colorScheme.onSurface.opacity(0.12f)
        )
    ) {
        Text(text = text)
    }
}

@Composable
@PreviewLightDark
private fun Preview() {
    BbcNewsChallengeTheme {
        OutlinedButton(text = "Label") { }
    }
}