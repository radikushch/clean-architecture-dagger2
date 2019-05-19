package com.radik.labs.evo_test_project.data.database

import androidx.paging.DataSource
import androidx.room.*
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NoteDao {

    @Query("SELECT * FROM note ORDER BY createTimeMillis DESC")
    fun getNotesDesc(): DataSource.Factory<Int, Note>

    @Query("SELECT * FROM note ORDER BY createTimeMillis ASC")
    fun getNotesAsc(): DataSource.Factory<Int, Note>

    @Query("SELECT * FROM note WHERE text LIKE :textPattern")
    fun getNotesPattern(textPattern: String): DataSource.Factory<Int, Note>

    @Query("SELECT * FROM note WHERE id >= :offset AND id <= :amount")
    fun getBatchNotes(offset: Int, amount: Int): List<Note>

    @Insert
    fun insertNote(note: Note): Long

    @Query("SELECT * FROM note")
    fun getNotes(): Single<List<Note>>

    @Update
    fun updateNote(note: Note)

    @Delete
    fun removeNote(note: Note)
}