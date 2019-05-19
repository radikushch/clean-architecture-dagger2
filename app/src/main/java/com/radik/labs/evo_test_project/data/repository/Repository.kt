package com.radik.labs.evo_test_project.data.repository

import androidx.paging.DataSource
import io.reactivex.Completable
import io.reactivex.Single

interface Repository<T, K> {

    fun save(item: T): Completable

    fun getAll(): Single<List<T>>

    fun update(item: T): Completable

    fun remove(item: T): Completable

    fun getAllDesc(): DataSource.Factory<K, T>

    fun getAllAsc(): DataSource.Factory<K, T>

    fun getBatchNotes(offset: Int, amount: Int): List<T>
}