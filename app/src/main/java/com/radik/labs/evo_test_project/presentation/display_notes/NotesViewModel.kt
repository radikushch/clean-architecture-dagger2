package com.radik.labs.evo_test_project.presentation.display_notes

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NotesViewModel @Inject constructor(val appDatabase: AppDatabase): ViewModel() {

    init {
        Log.e("testing", "Init NotesViewModel")
    }

    private var disposable: Disposable? = null

    val resLiveData = MutableLiveData<List<Note>>()

    fun create() {
        Handler().postDelayed({
            disposable = appDatabase.noteDao().getNotes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    resLiveData.postValue(it)
                }, {
                    Log.e("test", it.message)
                })
        }, 2000)

    }

    override fun onCleared() {
        Log.e("testing", "Clear NotesViewModel")
        disposable?.dispose()
        super.onCleared()
    }
}