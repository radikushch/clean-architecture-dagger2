package com.radik.labs.evo_test_project.domain.usecases

import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable

interface SaveUseCase<T> {

    fun saveNote(note: T) : Completable
}