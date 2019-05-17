package com.radik.labs.evo_test_project.domain.usecases

import io.reactivex.Completable

interface UpdateUseCase<T> {

    fun update(note: T): Completable
}