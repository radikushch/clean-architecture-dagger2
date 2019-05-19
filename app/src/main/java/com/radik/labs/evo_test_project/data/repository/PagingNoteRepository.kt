package com.radik.labs.evo_test_project.data.repository

import androidx.paging.DataSource
import androidx.room.Dao
import com.radik.labs.evo_test_project.data.database.NoteDao
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class PagingNoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val noteRepository: Repository<Note>
) : FilterRepository<Note, Int> {

    override fun getAllPattern(textPattern: String): DataSource.Factory<Int, Note> {
        return noteDao.getNotesPattern(textPattern)
    }

    override fun getAllDesc(): DataSource.Factory<Int, Note> {
        return noteDao.getNotesDesc()
    }

    override fun getAllAsc(): DataSource.Factory<Int, Note> {
        return noteDao.getNotesAsc()
    }

    override fun getBatchNotes(offset: Int, amount: Int): List<Note> {
        return noteDao.getBatchNotes(offset, amount)
    }

    override fun save(item: Note): Completable {
        return noteRepository.save(item)
    }

    override fun getAll(): Single<List<Note>> {
        return noteRepository.getAll()
    }

    override fun update(item: Note): Completable {
        return noteRepository.update(item)
    }

    override fun remove(item: Note): Completable {
        return noteRepository.remove(item)
    }
}