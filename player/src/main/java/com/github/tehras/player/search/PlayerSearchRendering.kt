package com.github.tehras.player.search

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.Text
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxSize
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.squareup.workflow.ui.compose.composedViewFactory
import com.squareup.workflow.ui.compose.tooling.preview

data class PlayerSearchRendering(
    val onSearch: (String) -> Unit
)

val PlayerSearchBinding = composedViewFactory<PlayerSearchRendering> { rendering, _ ->
    val textState = state { "" }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalGravity = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to PUBG Stats!",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        TextBox(
            hint = "Search for player",
            onSubmit = { text -> rendering.onSearch(text) },
            onValueChange = { textState.value = it }
        )
        Button(
            text = { Text("Search") },
            modifier = Modifier.padding(top = 24.dp),
            onClick = { rendering.onSearch(textState.value) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DrawPlayerSearchBinding() {
    PlayerSearchBinding.preview(PlayerSearchRendering {})
}