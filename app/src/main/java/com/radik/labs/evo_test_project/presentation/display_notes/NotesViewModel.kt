package com.radik.labs.evo_test_project.presentation.display_notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.radik.labs.evo_test_project.data.repository.FilterPaginationRepository
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.model.SortType
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import javax.inject.Inject

class NotesViewModel @Inject constructor(
    private val noteRepository: FilterPaginationRepository<Note, Int>,
    private val pagedListConfig: PagedList.Config,
    private var sortType: SortType
): BaseViewModel() {

    val notesPagedListLiveData = MediatorLiveData<PagedList<Note>>()
    private var ascLiveData: LiveData<PagedList<Note>> =
        LivePagedListBuilder<Int, Note>(noteRepository.getAllAsc(), pagedListConfig)
            .build()
    private var descLiveData: LiveData<PagedList<Note>> =
        LivePagedListBuilder<Int, Note>(noteRepository.getAllDesc(), pagedListConfig)
            .build()
    private var filterLiveData: LiveData<PagedList<Note>> =
        LivePagedListBuilder<Int, Note>(noteRepository.getAllPattern("%%"), pagedListConfig)
        .build()

    override fun start() {
    }

    init {
        initList()
    }

    fun initList() {
        when(sortType) {
            SortType.NEW_OLD_ASC -> {
                setAscPagedList()
            }
            SortType.OLD_NEW_DESC -> {
                setDescPagedList()
            }
        }
    }

    fun setAscPagedList() {
        sortType = SortType.NEW_OLD_ASC
        removeAllSources()
        notesPagedListLiveData.addSource(ascLiveData) {
            notesPagedListLiveData.postValue(it)
        }
    }

    fun setDescPagedList() {
        sortType = SortType.OLD_NEW_DESC
        removeAllSources()
        notesPagedListLiveData.addSource(descLiveData) {
            notesPagedListLiveData.postValue(it)
        }
    }

    fun setFilterPagedList(textPattern: String) {
        val dbPattern = "%$textPattern%"
        filterLiveData =
        LivePagedListBuilder<Int, Note>(noteRepository.getAllPattern(dbPattern), pagedListConfig)
            .build()
        removeAllSources()
        notesPagedListLiveData.addSource(filterLiveData) {
            notesPagedListLiveData.postValue(it)
        }
    }

    private fun removeAllSources() {
        notesPagedListLiveData.removeSource(descLiveData)
        notesPagedListLiveData.removeSource(ascLiveData)
        notesPagedListLiveData.removeSource(filterLiveData)
    }

    override fun stop() {

    }
}