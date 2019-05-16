package com.radik.labs.evo_test_project.presentation.display_notes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.radik.labs.evo_test_project.domain.usecases.GetAllNotesUseCase
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase
): BaseViewModel() {

    private var disposable: Disposable? = null

    val notesLiveData = MutableLiveData<List<Note>>()

    override fun start() {
        loadNotes()
    }

    private fun loadNotes() {
        disposable = getAllNotesUseCase.getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showProgress() }
            .subscribe({
                notesLiveData.postValue(it)
                hideProgress()
            }, {
                Log.e("test", it.message)
                hideProgress()
            })
    }

    override fun stop() {
        disposable?.dispose()
    }

    override fun onCleared() {
        disposable?.let { disp ->
            if(!disp.isDisposed) disp.dispose()
        }
        super.onCleared()
    }
}