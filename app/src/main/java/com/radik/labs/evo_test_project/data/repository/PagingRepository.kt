package com.radik.labs.evo_test_project.data.repository

import androidx.paging.DataSource

interface PagingRepository<T, K> : Repository<T> {

    fun getAllDesc(): DataSource.Factory<K, T>

    fun getAllAsc(): DataSource.Factory<K, T>

    fun getBatchNotes(offset: Int, amount: Int): List<T>
}