package com.example.note_compose.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.note_compose.ui.addnote.AddNoteActivity
import com.example.note_compose.ui.main.component.ItemNote
import com.example.note_compose.ui.main.component.TextFieldSearchNote
import com.example.note_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotecomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val noteItems = listOf<String>("", "", "")
    Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
        FloatingActionButton(onClick = {
            context.startActivity(
                Intent(
                    context,
                    AddNoteActivity::class.java
                )
            )
        }, backgroundColor = Purple) {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = null, tint = White)
        }
    }) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkPrimaryColor)
        ) {
            val (textFieldSearchNote, labelRecent, listNoteRecent) = createRefs()

            TextFieldSearchNote(
                Modifier
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
                    .background(color = DarkColorAccent, shape = RoundedCornerShape(6.dp))
                    .constrainAs(textFieldSearchNote) {
                        top.linkTo(parent.top)
                    }
            )

            Text(
                text = "Recent",
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
                    .constrainAs(labelRecent) {
                        top.linkTo(textFieldSearchNote.bottom)
                    },
                style = TextStyle(color = White), fontSize = 24.sp
            )

            LazyColumn(content = {
                items(noteItems) {
                    ItemNote()
                    Divider(color = DarkGrayIconColor, thickness = 1.dp)
                }
            }, modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .constrainAs(listNoteRecent) {
                    top.linkTo(labelRecent.bottom, margin = 12.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                }
                .fillMaxHeight(fraction = .8f))

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotecomposeTheme {
        MainScreen()
    }
}