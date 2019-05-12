package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideMainView(mainActivity: MainActivity): MainActivity {
        return mainActivity
    }
}