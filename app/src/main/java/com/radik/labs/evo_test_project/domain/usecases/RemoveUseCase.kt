package com.radik.labs.evo_test_project.domain.usecases

import io.reactivex.Completable

interface RemoveUseCase<T> {

    fun remove(item: T): Completable
}