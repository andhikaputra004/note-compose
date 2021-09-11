package com.example.note_compose.data

import javax.inject.Inject

class NoteRepository @Inject constructor(private val appDatabase: AppDatabase) {

    private val noteDao = appDatabase.noteDao()

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }


}