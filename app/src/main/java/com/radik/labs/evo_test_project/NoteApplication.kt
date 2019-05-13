package com.radik.labs.evo_test_project

import com.radik.labs.evo_test_project.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class NoteApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}