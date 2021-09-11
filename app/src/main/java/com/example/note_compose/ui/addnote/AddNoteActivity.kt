package com.example.note_compose.ui.addnote

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.note_compose.ui.addnote.component.TextFieldAddNoteContent
import com.example.note_compose.ui.addnote.component.TextFieldAddNoteTitle
import com.example.note_compose.ui.theme.DarkPrimaryColor
import com.example.note_compose.ui.theme.NotecomposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddNoteActivity : ComponentActivity() {

    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotecomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AddNoteScreen()
                }
            }
        }

    }
}

@Composable
fun AddNoteScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkPrimaryColor)
        ) {
            val (textFieldTitle, textFieldContent) = createRefs()

            TextFieldAddNoteTitle(modifier = Modifier
                .fillMaxWidth()
                .constrainAs(textFieldTitle) {
                    top.linkTo(parent.top, margin = 24.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                })

            TextFieldAddNoteContent(
                modifier = Modifier
                    .constrainAs(textFieldContent) {
                        top.linkTo(textFieldTitle.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = .9f))
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