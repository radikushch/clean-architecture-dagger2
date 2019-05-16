package com.radik.labs.evo_test_project.di

import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.domain.GetSaveNotesInteractor
import com.radik.labs.evo_test_project.domain.usecases.GetAllNotesUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class NotesUseCaseModule {

    @ActivityScope
    @Binds
    abstract fun bindGetAllNotesUseCase(getAllNotesUseCase: GetSaveNotesInteractor): GetAllNotesUseCase
}