package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.data.repository.FilterRepository
import com.radik.labs.evo_test_project.data.repository.NoteRepository
import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.model.Note
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @ActivityScope
    @Binds
    abstract fun bindNoteRepository(noteRepository: NoteRepository): FilterRepository<Note, Int>

}