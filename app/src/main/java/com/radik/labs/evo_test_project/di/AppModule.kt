package com.radik.labs.evo_test_project.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.di.viewmodel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "note-database"
        ).build()
    }
}