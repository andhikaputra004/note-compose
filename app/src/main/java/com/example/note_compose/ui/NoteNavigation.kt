package com.example.note_compose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.note_compose.ui.addnote.AddNoteScreen
import com.example.note_compose.ui.main.MainScreen
import com.example.note_compose.utils.NavConstant.ADD_NOTE
import com.example.note_compose.utils.NavConstant.HOME

@Composable
fun NoteNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME) {

        composable(HOME) {
            MainScreen(navController)
        }

        composable(ADD_NOTE) {
            AddNoteScreen()
        }
    }
}