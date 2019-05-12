package com.radik.labs.evo_test_project.di

import dagger.Module
import android.app.Application
import android.content.Context
import dagger.Binds

@Module
abstract class ContextModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}