package com.bbcnewschallenge.core.designsystem.components.buttons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bbcnewschallenge.core.designsystem.theme.BbcNewsChallengeTheme

@Composable
fun ElevatedButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.elevatedButtonColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        )
    ) {
        Text(text = text)
    }
}

@Composable
@PreviewLightDark
private fun Preview() {
    BbcNewsChallengeTheme {
        ElevatedButton(text = "Label") { }
    }
}