package com.radik.labs.evo_test_project.di

import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.domain.GetSaveNotesInteractor
import com.radik.labs.evo_test_project.domain.UpdateNoteInteractor
import com.radik.labs.evo_test_project.domain.usecases.GetAllUseCase
import com.radik.labs.evo_test_project.domain.usecases.SaveUseCase
import com.radik.labs.evo_test_project.domain.usecases.UpdateUseCase
import com.radik.labs.evo_test_project.model.Note
import dagger.Binds
import dagger.Module

@Module
abstract class NotesUseCaseModule {

    @ActivityScope
    @Binds
    abstract fun bindGetAllNotesUseCase(getAllNotesUseCase: GetSaveNotesInteractor): GetAllUseCase<Note>

    @ActivityScope
    @Binds
    abstract fun bindSaveNoteUseCase(saveNoteUseCase: GetSaveNotesInteractor): SaveUseCase<Note>

    @FragmentScope
    @Binds
    abstract fun bindUpdateUSeCase(updateUseCase: UpdateNoteInteractor): UpdateUseCase<Note>
}