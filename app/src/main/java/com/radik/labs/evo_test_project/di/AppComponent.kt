package com.radik.labs.evo_test_project.di

import android.app.Application
import com.radik.labs.evo_test_project.NoteApplication
import com.radik.labs.evo_test_project.di.activity.ActivitiesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidInjectionModule::class,
    ActivitiesModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: NoteApplication)
}