package com.radik.labs.evo_test_project.di.activity

import com.radik.labs.evo_test_project.MainActivity
import com.radik.labs.evo_test_project.di.fragment.MainFragmentBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MainFragmentBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}