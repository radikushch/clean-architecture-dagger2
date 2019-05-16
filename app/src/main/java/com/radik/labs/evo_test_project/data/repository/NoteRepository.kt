package com.radik.labs.evo_test_project.data.repository

import com.radik.labs.evo_test_project.data.database.NoteDao
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject

@ActivityScope
class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
) : Repository<Note> {

    override fun save(item: Note): Completable {
        return Completable.create { emmiter ->
            try{
                noteDao.insertNote(item)
            }catch (exc: Exception) {
                emmiter.onError(exc)
            }
        }
    }

    override fun getAll(): Single<List<Note>> {
        return noteDao.getNotes()
    }

}