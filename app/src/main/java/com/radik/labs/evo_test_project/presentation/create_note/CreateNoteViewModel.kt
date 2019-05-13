package com.radik.labs.evo_test_project.presentation.create_note

import android.util.Log
import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.model.Note
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CreateNoteViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var appDatabase: AppDatabase

    init {
        Log.e("testing", "Init CreateViewModel")
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
        Log.e("testing", "Clear CreateViewModel")
        disposable?.dispose()
        super.onCleared()
    }
}