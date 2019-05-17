package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.domain.GetSaveInteractor
import com.radik.labs.evo_test_project.domain.RemoveInteractor
import com.radik.labs.evo_test_project.domain.UpdateInteractor
import com.radik.labs.evo_test_project.domain.usecases.GetAllUseCase
import com.radik.labs.evo_test_project.domain.usecases.RemoveUseCase
import com.radik.labs.evo_test_project.domain.usecases.SaveUseCase
import com.radik.labs.evo_test_project.domain.usecases.UpdateUseCase
import com.radik.labs.evo_test_project.model.Note
import dagger.Binds
import dagger.Module

@Module
abstract class NotesUseCaseModule {

    @ActivityScope
    @Binds
    abstract fun bindGetAllNotesUseCase(getAllNotesUseCase: GetSaveInteractor<Note>): GetAllUseCase<Note>

    @ActivityScope
    @Binds
    abstract fun bindSaveNoteUseCase(saveNoteUseCase: GetSaveInteractor<Note>): SaveUseCase<Note>

    @ActivityScope
    @Binds
    abstract fun bindUpdateUseCase(updateUseCase: UpdateInteractor<Note>): UpdateUseCase<Note>

    @ActivityScope
    @Binds
    abstract fun bindRemoveUseCase(removeUseCase: RemoveInteractor<Note>): RemoveUseCase<Note>
}