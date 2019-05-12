package com.radik.labs.evo_test_project.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.main_activity.*

abstract class ToolbarFragment : BaseFragment(){

    protected var hostToolbarActivity: ToolbarActivity? = null
    protected lateinit var navController: NavController

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is ToolbarActivity) hostToolbarActivity = context
    }

    override fun onDetach() {
        hostToolbarActivity = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        init()
    }

    private fun init() {
        initToolBarLayout()
    }

    private fun initToolBarLayout() {
        hostToolbarActivity?.let { activity ->
            activity.apply {
                val toolbarView = layoutInflater.inflate(toolbarLayoutRes(), toolbar_layout, false)
                toolbar_layout.removeAllViews()
                toolbar_layout.addView(toolbarView)
            }
        }
    }

    @LayoutRes abstract fun toolbarLayoutRes() : Int
}

