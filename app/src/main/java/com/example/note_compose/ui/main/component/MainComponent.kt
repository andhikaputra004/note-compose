package com.example.note_compose.ui.main.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.note_compose.data.Note
import com.example.note_compose.ui.theme.DarkGrayIconColor
import com.example.note_compose.ui.theme.DarkSecondTextColor
import com.example.note_compose.ui.theme.DarkTextColor
import com.example.note_compose.ui.theme.White

@Composable
fun TextFieldSearchNote(modifier: Modifier) {
    val (text, setText) = mutableStateOf("")
    TextField(
        value = text,
        onValueChange = setText,
        label = { Text(text = "Search Note", style = TextStyle(color = DarkTextColor)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = DarkTextColor
            )
        },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            disabledTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun ItemNote(note: Note?) {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 12.dp, end = 12.dp, top = 6.dp, bottom = 6.dp)
            .fillMaxWidth()
    ) {
        val (titleLabel, dateCreatedLabel, iconArrowRight) = createRefs()

        Text(
            text = note?.title ?: "",
            fontSize = 18.sp,
            style = TextStyle(color = White),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(titleLabel) {
                    top.linkTo(parent.top, margin = 12.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                    end.linkTo(iconArrowRight.start, margin = 12.dp)
                }
        )

        Text(text = note?.createdDate ?: "",
            fontSize = 14.sp,
            style = TextStyle(color = DarkSecondTextColor),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(dateCreatedLabel) {
                    top.linkTo(titleLabel.bottom, margin = 6.dp)
                    start.linkTo(parent.start, margin = 12.dp)
                    end.linkTo(iconArrowRight.start, margin = 12.dp)
                })

        Icon(
            imageVector = Icons.Outlined.ArrowForward,
            contentDescription = null,
            tint = DarkGrayIconColor,
            modifier = Modifier.constrainAs(iconArrowRight) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
            }
        )
    }
}