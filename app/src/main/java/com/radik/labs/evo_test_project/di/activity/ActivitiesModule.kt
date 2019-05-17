package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.MainActivity
import com.radik.labs.evo_test_project.di.fragment.MainActivityFragmentsModule
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityFragmentsModule::class,
        NotesUseCaseModule::class,
        RepositoryModule::class
    ])
    abstract fun bindMainActivity(): MainActivity
}