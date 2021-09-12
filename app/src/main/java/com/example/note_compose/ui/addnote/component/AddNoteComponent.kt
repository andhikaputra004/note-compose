package com.example.note_compose.ui.addnote.component

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.note_compose.ui.theme.DarkTextColor
import com.example.note_compose.ui.theme.White

@Composable
fun TextFieldAddNoteTitle(textState: MutableState<String>?, modifier: Modifier) {

    TextField(
        value = textState?.value ?: "",
        onValueChange = { textState?.value = it },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            textColor = White
        ), placeholder = {
            Text(text = "Title", style = TextStyle(color = DarkTextColor))
        }
    )
}

@Composable
fun TextFieldAddNoteContent(textState: MutableState<String>?, modifier: Modifier) {
    TextField(
        value = textState?.value ?: "",
        onValueChange = { textState?.value = it },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            textColor = White
        ), placeholder = {
            Text(text = "Content", style = TextStyle(color = DarkTextColor))
        }
    )
}