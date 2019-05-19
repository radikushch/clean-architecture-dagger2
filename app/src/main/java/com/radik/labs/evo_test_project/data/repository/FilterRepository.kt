package com.radik.labs.evo_test_project.data.repository

import androidx.paging.DataSource

interface FilterRepository<T, K> : Repository<T, K> {

    fun getAllPattern(textPattern: String): DataSource.Factory<K, T>
}