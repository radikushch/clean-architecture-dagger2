package com.radik.labs.evo_test_project.di.fragment

import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.di.viewmodel.CreateNotesFragmentModule
import com.radik.labs.evo_test_project.di.viewmodel.NotesFragmentModule
import com.radik.labs.evo_test_project.presentation.create_note.CreateNoteFragment
import com.radik.labs.evo_test_project.presentation.display_notes.NotesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [NotesFragmentModule::class])
    abstract fun provideNotesFragment(): NotesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CreateNotesFragmentModule::class])
    abstract fun provideCreateNoteFragment(): CreateNoteFragment
}
