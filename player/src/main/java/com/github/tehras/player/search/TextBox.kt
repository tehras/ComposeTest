package com.github.tehras.player.search

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.foundation.Text
import androidx.ui.input.ImeAction
import androidx.ui.material.FilledTextField
import androidx.ui.tooling.preview.Preview

@Composable
fun TextBox(
    hint: String = "",
    onValueChange: (text: String) -> Unit = {},
    onSubmit: (text: String) -> Unit = {}
) {
    val text = state { "" }

    FilledTextField(
        value = text.value,
        onValueChange = { newValue ->
            onValueChange(newValue)
            text.value = newValue
        },
        label = { Text(hint) },
        imeAction = ImeAction.Search,
        onImeActionPerformed = { action, softwareController ->
            if (action == ImeAction.Search) {
                softwareController?.hideSoftwareKeyboard()
                onSubmit(text.value)
            }
        }
    )
}

@Preview(heightDp = 150, showBackground = true)
@Composable
private fun PreviewSearchBox() = TextBox(hint = "Enter text")