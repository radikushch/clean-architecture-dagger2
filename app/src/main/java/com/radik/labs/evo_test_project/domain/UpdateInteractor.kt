package com.radik.labs.evo_test_project.domain

import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.domain.usecases.UpdateUseCase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import javax.inject.Inject

class UpdateInteractor<T> @Inject constructor(
    private val repository: Repository<T>
) : UpdateUseCase<T> {

    override fun update(note: T): Completable {
        return repository.update(note)
    }
}