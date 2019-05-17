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
class GetSaveInteractor<T> @Inject constructor(
    private val repository: Repository<T>
) : GetAllUseCase<T>, SaveUseCase<T> {

    override fun saveNote(note: T): Completable {
        return repository.save(note)
    }

    override fun getAllNotes(): Single<List<T>> {
        return repository.getAll()
    }
}