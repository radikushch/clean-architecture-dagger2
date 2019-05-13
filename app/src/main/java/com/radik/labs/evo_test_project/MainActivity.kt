package com.radik.labs.evo_test_project

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.presentation.base.ToolbarActivity
import dagger.android.support.HasSupportFragmentInjector

@ActivityScope
class MainActivity : ToolbarActivity(){

    override fun layoutRes(): Int = R.layout.main_activity

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = Navigation.findNavController(this, R.id.main_nav_host)
    }
}