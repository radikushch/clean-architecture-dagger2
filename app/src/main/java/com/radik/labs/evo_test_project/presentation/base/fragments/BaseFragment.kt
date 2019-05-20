package com.radik.labs.evo_test_project.presentation.base.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.radik.labs.evo_test_project.LoadingFragment
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.di.viewmodel.ViewModelFactory
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import com.radik.labs.evo_test_project.presentation.base.activities.HostFragmentActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@FragmentScope
abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected var hostActivity: HostFragmentActivity? = null
    private var loadingFragment: LoadingFragment? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is HostFragmentActivity) hostActivity = context
    }

    override fun onDetach() {
        hostActivity = null
        super.onDetach()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes(), container, false)
    }

    @LayoutRes abstract fun layoutRes() : Int

    protected fun showProgress() {
        loadingFragment = LoadingFragment()
        loadingFragment!!.show(hostActivity?.supportFragmentManager, "loading_fragment")

    }

    protected fun hideProgress() {
        loadingFragment?.dismissAllowingStateLoss()
        loadingFragment = null
    }
}