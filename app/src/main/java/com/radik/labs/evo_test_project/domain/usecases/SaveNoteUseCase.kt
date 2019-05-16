package com.radik.labs.evo_test_project.domain.usecases

import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable

interface SaveNoteUseCase {

    fun saveNote(note: Note) : Completable
}