package com.radik.labs.evo_test_project.di.activity

import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.model.SortType
import com.radik.labs.evo_test_project.presentation.display_notes.pagination_adapter.NoteDiffUtilCallback
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PaginationModule {

    @ActivityScope
    @Provides
    fun providePagedListConfig(): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()
    }

    @ActivityScope
    @Provides
    fun provideSortType(): SortType = SortType.OLD_NEW_DESC

    @ActivityScope
    @Provides
    fun provideDiffUtils(): DiffUtil.ItemCallback<Note> = NoteDiffUtilCallback()
}