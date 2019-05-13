package com.radik.labs.evo_test_project.di.viewmodel

import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class CreateNotesViewModelModule {

    @ActivityScope
    @Binds
    abstract fun bindCreateViewModel(createViewModel: CreateNoteViewModel): ViewModel
}