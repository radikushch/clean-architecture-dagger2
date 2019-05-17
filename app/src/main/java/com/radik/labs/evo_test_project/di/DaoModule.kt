package com.radik.labs.evo_test_project.di

import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.data.database.NoteDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DaoModule {

    @Singleton
    @Provides
    fun provideNoteDao(appDatabase: AppDatabase): NoteDao {
        return appDatabase.noteDao()
    }

}