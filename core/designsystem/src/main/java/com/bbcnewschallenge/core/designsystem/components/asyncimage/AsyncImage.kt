package com.bbcnewschallenge.core.designsystem.components.asyncimage

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun AsyncImage(
    modifier: Modifier = Modifier,
    url: String,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.None
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = contentScale,
        alignment = alignment,
        loading = {
            CircularProgressIndicator()
        },
    )
}