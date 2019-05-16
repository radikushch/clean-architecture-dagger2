package com.radik.labs.evo_test_project.presentation.base.activities

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.radik.labs.evo_test_project.di.AppComponent
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

@ActivityScope
abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
    }

    @LayoutRes abstract fun layoutRes(): Int
}