package com.github.tehras.uicommon.renderings

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.wrapContentSize
import androidx.ui.material.CircularProgressIndicator
import androidx.ui.material.IconButton
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Clear
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.squareup.workflow.ui.compose.composedViewFactory
import com.squareup.workflow.ui.compose.tooling.preview

data class LoadingRendering(
    val text: String,
    val onBack: () -> Unit
)

val LoadingRenderingBinding = composedViewFactory<LoadingRendering> { rendering, _ ->
    Scaffold(
        topAppBar = {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(
                        onClick = { rendering.onBack() },
                        icon = { Icon(Icons.Filled.Clear) }
                    )
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.Center)) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DrawPlayerSearchBinding() {
    LoadingRenderingBinding.preview(LoadingRendering(text = "") {})
}