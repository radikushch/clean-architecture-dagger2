package com.radik.labs.evo_test_project.di.viewmodel

import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteViewModel
import com.radik.labs.evo_test_project.presentation.display_notes.NotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CreateNotesFragmentModule {

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(CreateNoteViewModel::class)
    abstract fun bindCreateViewModel(createViewModel: CreateNoteViewModel): ViewModel

}