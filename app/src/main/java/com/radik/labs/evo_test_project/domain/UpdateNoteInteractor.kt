package com.radik.labs.evo_test_project.domain

import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.domain.usecases.UpdateUseCase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import javax.inject.Inject

class UpdateNoteInteractor @Inject constructor(
    private val noteRepository: Repository<Note>
) : UpdateUseCase<Note> {

    override fun update(note: Note): Completable {
        return noteRepository.update(note)
    }

}