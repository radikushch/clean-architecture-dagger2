package com.radik.labs.evo_test_project.domain

import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.domain.usecases.GetAllUseCase
import com.radik.labs.evo_test_project.domain.usecases.SaveUseCase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

@ActivityScope
class GetSaveNotesInteractor @Inject constructor(
    private val noteRepository: Repository<Note>
) : GetAllUseCase<Note>, SaveUseCase<Note> {

    override fun saveNote(note: Note): Completable {
        return noteRepository.save(note)
    }

    override fun getAllNotes(): Single<List<Note>> {
        return noteRepository.getAll()
    }
}