package com.radik.labs.evo_test_project.di.viewmodel

import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteViewModel
import com.radik.labs.evo_test_project.presentation.display_notes.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModelProvider
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    abstract fun bindNotesViewModel(notesViewModel: NotesViewModel): ViewModel

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(CreateNoteViewModel::class)
    abstract fun bindCreateViewModel(createViewModel: CreateNoteViewModel): ViewModel

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}