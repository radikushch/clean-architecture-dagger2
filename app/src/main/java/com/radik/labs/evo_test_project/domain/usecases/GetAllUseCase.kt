package com.radik.labs.evo_test_project.domain.usecases

import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Single

interface GetAllUseCase<T> {

    fun getAllNotes() : Single<List<T>>
}