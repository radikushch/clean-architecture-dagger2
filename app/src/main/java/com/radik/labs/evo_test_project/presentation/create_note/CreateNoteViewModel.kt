package com.radik.labs.evo_test_project.presentation.create_note

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CreateNoteViewModel @Inject constructor(
    private val noteRepository: Repository<Note>
): BaseViewModel() {

    override fun start() {

    }

    override fun stop() {
        disposable?.dispose()
    }

    private var disposable: Disposable? = null
    val completeLiveData = MutableLiveData<Unit>()
    val errorLiveData = MutableLiveData<String>()


    fun saveNote(noteText: String) {
        if(noteText.isEmpty()){
            errorLiveData.postValue("Error! Your note can't be saved")
            return
        }
        val note = Note(
            noteText,
            System.currentTimeMillis()
        )
        cashNote(note)
    }

    private fun cashNote(note: Note) {
        disposable = noteRepository.save(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                completeLiveData.postValue(Unit)
            }, {
                errorLiveData.postValue("Error! Your note can't be saved")
            })

    }

    override fun onCleared() {
        disposable?.let {
            if(!it.isDisposed) it.dispose()
        }
        super.onCleared()
    }
}