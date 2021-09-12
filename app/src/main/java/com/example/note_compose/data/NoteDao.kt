package com.example.note_compose.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note")
    fun getNote(): LiveData<List<Note>>

}