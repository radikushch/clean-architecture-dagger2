package com.radik.labs.evo_test_project.presentation.edit_note

import androidx.lifecycle.MutableLiveData
import com.radik.labs.evo_test_project.data.repository.Repository
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.model.StorageResponse
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EditNoteViewModel @Inject constructor(
    private val noteRepository: Repository<Note>
) : BaseViewModel() {

    private var disposable: Disposable? = null
    val completeLiveData = MutableLiveData<Pair<StorageResponse, String>>()
    val errorLiveData = MutableLiveData<String>()

    override fun start() {

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

    fun removeNote(note: Note) {
        disposable = noteRepository.remove(note)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    completeLiveData.postValue(Pair(StorageResponse.DELETE, "Note was remove"))
                },
                {
                    errorLiveData.postValue("Unavailable to remove note")
                }
            )
    }

    fun updateNote(noteText: String, updatedNote: Note) {
        updatedNote.text = noteText
        updatedNote.createTimeMillis = System.currentTimeMillis()
        disposable = noteRepository.update(updatedNote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    completeLiveData.postValue(Pair(StorageResponse.UPDATE, "Note was update"))
                },
                {
                    errorLiveData.postValue("Unavailable to update note")
                }
            )
    }
}