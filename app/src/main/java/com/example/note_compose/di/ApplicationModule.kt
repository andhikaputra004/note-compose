package com.example.note_compose.di

import android.content.Context
import androidx.room.Room
import com.example.note_compose.data.AppDatabase
import com.example.note_compose.data.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "note.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesNoteRepository(appDatabase: AppDatabase) = NoteRepository(appDatabase = appDatabase)
}