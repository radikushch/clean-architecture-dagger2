package com.radik.labs.evo_test_project.domain

import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.data.database.NoteDao
import com.radik.labs.evo_test_project.data.repository.NoteRepository
import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.domain.usecases.GetAllNotesUseCase
import com.radik.labs.evo_test_project.domain.usecases.SaveNoteUseCase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject

@ActivityScope
class GetSaveNotesInteractor @Inject constructor(
    private val noteRepository: Repository<Note>
) : GetAllNotesUseCase, SaveNoteUseCase {

    override fun saveNote(note: Note): Completable {
        return noteRepository.save(note)
    }

    override fun getAllNotes(): Single<List<Note>> {
        return noteRepository.getAll()
    }
}