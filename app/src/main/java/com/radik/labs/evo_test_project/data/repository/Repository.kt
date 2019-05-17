package com.radik.labs.evo_test_project.data.repository

import io.reactivex.Completable
import io.reactivex.Single

interface Repository<T> {

    fun save(item: T): Completable

    fun getAll(): Single<List<T>>

    fun update(item: T): Completable

    fun remove(item: T): Completable
}