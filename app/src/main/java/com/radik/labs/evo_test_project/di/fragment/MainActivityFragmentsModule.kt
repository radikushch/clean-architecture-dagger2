package com.radik.labs.evo_test_project.di.fragment

import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteFragment
import com.radik.labs.evo_test_project.presentation.display_notes.NotesFragment
import com.radik.labs.evo_test_project.presentation.edit_note.EditNoteFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideNotesFragment(): NotesFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideCreateNoteFragment(): CreateNoteFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun provideEditFragment(): EditNoteFragment
}
