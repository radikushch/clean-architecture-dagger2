package com.radik.labs.evo_test_project.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Long

    @Query("SELECT * FROM note")
    fun getNotes(): Single<List<Note>>

}