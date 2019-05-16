package com.radik.labs.evo_test_project.presentation.base.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation

abstract class NavigationFragment : BaseFragment() {

    protected lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNavController(view)
    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }
}