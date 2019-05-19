package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.data.repository.*
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.model.Note
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @ActivityScope
    @Binds
    abstract fun bindNoteRepository(noteRepository: NoteRepository): Repository<Note>

    @ActivityScope
    @Binds
    abstract fun bindNotePagingFilterRepository(noteRepository: PagingNoteRepository): FilterRepository<Note, Int>

    @ActivityScope
    @Binds
    abstract fun bindNotePagingRepository(noteRepository: PagingNoteRepository): PagingRepository<Note, Int>

}