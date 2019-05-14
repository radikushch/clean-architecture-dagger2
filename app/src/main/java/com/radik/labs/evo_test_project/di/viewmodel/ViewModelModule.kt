package com.radik.labs.evo_test_project.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

//    @FragmentScope
//    @Binds
//    @IntoMap
//    @ViewModelKey(NotesViewModel::class)
//    abstract fun bindNotesViewModel(notesViewModel: NotesViewModel): ViewModel
//
//    @ActivityScope
//    @Binds
//    @IntoMap
//    @ViewModelKey(CreateNoteViewModel::class)
//    abstract fun bindCreateViewModel(createViewModel: CreateNoteViewModel): ViewModel

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}