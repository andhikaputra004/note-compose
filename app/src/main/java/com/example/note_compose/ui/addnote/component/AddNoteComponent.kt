package com.example.note_compose.ui.addnote.component

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.note_compose.ui.theme.DarkTextColor

@Composable
fun TextFieldAddNoteTitle(modifier: Modifier) {
    val (text, setText) = mutableStateOf("")
    TextField(
        value = text,
        onValueChange = setText,
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),placeholder = {
            Text(text = "Title",style = TextStyle(color = DarkTextColor))
        }
    )
}

@Composable
fun TextFieldAddNoteContent(modifier: Modifier) {
    val (text, setText) = mutableStateOf("")
    TextField(
        value = text,
        onValueChange = setText,
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),placeholder = {
            Text(text = "Content",style = TextStyle(color = DarkTextColor))
        }
    )
}