package com.radik.labs.evo_test_project.domain

import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.domain.usecases.RemoveUseCase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import javax.inject.Inject

class RemoveInteractor<T> @Inject constructor(
    private val repository: Repository<T>
) : RemoveUseCase<T> {

    override fun remove(item: T): Completable {
        return repository.remove(item)
    }
}