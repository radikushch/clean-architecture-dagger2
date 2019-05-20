package com.radik.labs.evo_test_project.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.radik.labs.evo_test_project.model.Note

@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao() : NoteDao
}