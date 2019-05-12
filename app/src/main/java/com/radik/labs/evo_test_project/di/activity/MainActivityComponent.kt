package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent  : AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}