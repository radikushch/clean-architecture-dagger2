package com.radik.labs.evo_test_project.di.fragment

import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.di.viewmodel.ViewModelModule
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteFragment
import com.radik.labs.evo_test_project.presentation.display_notes.NotesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBindingModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideNotesFragment(): NotesFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideCreateNoteFragment(): CreateNoteFragment
}
