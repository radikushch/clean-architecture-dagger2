package com.radik.labs.evo_test_project.presentation.create_note

import android.util.Log
import androidx.lifecycle.ViewModel
import com.radik.labs.evo_test_project.data.database.AppDatabase
import com.radik.labs.evo_test_project.domain.usecases.SaveUseCase
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CreateNoteViewModel @Inject constructor(
    private val saveUseCase: SaveUseCase<Note>
): BaseViewModel() {

    override fun start() {

    }

    override fun stop() {
        disposable?.dispose()
    }

    private var disposable: Disposable? = null

    fun saveNote(noteText: String) {
        val note = Note(
            noteText,
            System.currentTimeMillis()
        )
        cashNote(note)
    }

    private fun cashNote(note: Note) {
        disposable = saveUseCase.saveNote(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("test", "complete")
            }, {
                Log.e("test", it.message)
            })

    }

    override fun onCleared() {
        disposable?.let {
            if(!it.isDisposed) it.dispose()
        }
        super.onCleared()
    }
}