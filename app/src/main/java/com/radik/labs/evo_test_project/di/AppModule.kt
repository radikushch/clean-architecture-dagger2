package com.radik.labs.evo_test_project.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.di.activity.PaginationModule
import com.radik.labs.evo_test_project.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, DaoModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note-database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}