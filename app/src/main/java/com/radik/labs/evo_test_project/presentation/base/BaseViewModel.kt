package com.radik.labs.evo_test_project.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    val progressLiveData = MutableLiveData<Boolean>()

    fun hideProgress() = progressLiveData.postValue(false)

    fun showProgress() = progressLiveData.postValue(true)

    abstract fun start()

    abstract fun stop()
}