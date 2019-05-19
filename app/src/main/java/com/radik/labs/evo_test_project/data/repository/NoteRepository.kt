package com.radik.labs.evo_test_project.data.repository

import androidx.paging.DataSource
import com.radik.labs.evo_test_project.data.database.NoteDao
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject

@ActivityScope
open class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) : Repository<Note> {

    override fun remove(item: Note): Completable {
        return Completable.create { emitter ->
            try{
                noteDao.removeNote(item)
                emitter.onComplete()
            }catch (exc: Exception) {
                emitter.onError(exc)
            }
        }
    }

    override fun update(item: Note): Completable {
        return Completable.create { emitter ->
            try{
                noteDao.updateNote(item)
                emitter.onComplete()
            }catch (exc: Exception) {
                emitter.onError(exc)
            }
        }
    }

    override fun save(item: Note): Completable {
        return Completable.create { emitter ->
            try{
                noteDao.insertNote(item)
                emitter.onComplete()
            }catch (exc: Exception) {
                emitter.onError(exc)
            }
        }
    }

    override fun getAll(): Single<List<Note>> {
        return noteDao.getNotes()
    }
}