package com.radik.labs.evo_test_project.presentation.create_note

import android.util.Log
import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CreateNoteViewModel @Inject constructor(val appDatabase: AppDatabase): BaseViewModel() {

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var disposable: Disposable? = null

    fun addNote(note: String) {
        disposable = Completable.fromAction {
            appDatabase.noteDao().insertNote(Note(
                note,
                System.currentTimeMillis())
            )}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("test", "complete")
            }, {
                Log.e("test", it.message)
            })
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}