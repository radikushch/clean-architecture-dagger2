package com.radik.labs.evo_test_project.domain.usecases

import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Single

interface GetAllNotesUseCase {

    fun getAllNotes() : Single<List<Note>>
}