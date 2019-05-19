package com.radik.labs.evo_test_project.di.viewmodel

import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.presentation.display_notes.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NotesFragmentModule {

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(NotesViewModel::class)
    abstract fun bindNotesViewModel(notesViewModel: NotesViewModel): ViewModel
}