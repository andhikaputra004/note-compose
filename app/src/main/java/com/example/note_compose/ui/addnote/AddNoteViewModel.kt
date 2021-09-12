package com.example.note_compose.ui.addnote

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_compose.data.Note
import com.example.note_compose.data.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val textFieldTitle = mutableStateOf("")

    val textFieldContent = mutableStateOf("")

    fun insertNote(note: Note) {
        viewModelScope.launch {
            repository.insertNote(note)
        }
    }
}