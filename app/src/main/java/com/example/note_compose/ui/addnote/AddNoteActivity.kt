package com.example.note_compose.ui.addnote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.note_compose.ui.addnote.component.TextFieldAddNoteContent
import com.example.note_compose.ui.addnote.component.TextFieldAddNoteTitle
import com.example.note_compose.ui.theme.DarkPrimaryColor
import com.example.note_compose.ui.theme.NotecomposeTheme


@Composable
fun AddNoteScreen() {

    val viewModel: AddNoteViewModel = hiltViewModel()

    Scaffold(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkPrimaryColor)
        ) {
            val (textFieldTitle, textFieldContent) = createRefs()


            TextFieldAddNoteTitle(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(textFieldTitle) {
                        top.linkTo(parent.top, margin = 24.dp)
                        start.linkTo(parent.start, margin = 24.dp)
                        end.linkTo(parent.end, margin = 24.dp)
                    }, textState = viewModel.textFieldTitle
            )

            TextFieldAddNoteContent(
                modifier = Modifier
                    .constrainAs(textFieldContent) {
                        top.linkTo(textFieldTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = .9f), textState = viewModel.textFieldContent)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddNotePreview() {
    NotecomposeTheme {
        AddNoteScreen()
    }
}