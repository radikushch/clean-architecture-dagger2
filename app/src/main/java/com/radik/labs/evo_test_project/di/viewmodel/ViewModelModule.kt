package com.radik.labs.evo_test_project.di.viewmodel

import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteViewModel
import com.radik.labs.evo_test_project.presentation.display_notes.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModelProvider
import com.radik.labs.evo_test_project.di.ViewModelFactory
import com.radik.labs.evo_test_project.di.ViewModelKey

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    abstract fun bindNotesViewModel(notesViewModel: NotesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateNoteViewModel::class)
    abstract fun bindCreateViewModel(createViewModel: CreateNoteViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}