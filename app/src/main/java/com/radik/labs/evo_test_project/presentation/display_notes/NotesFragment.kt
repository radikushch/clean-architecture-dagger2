package com.radik.labs.evo_test_project.presentation.display_notes

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.fragments.NavigationFragment
import com.radik.labs.evo_test_project.presentation.display_notes.adapter.NoteAdapter
import com.radik.labs.evo_test_project.presentation.display_notes.pagination_adapter.NoteDiffUtilCallback
import com.radik.labs.evo_test_project.presentation.display_notes.pagination_adapter.NotePagingAdapter
import com.radik.labs.evo_test_project.presentation.edit_note.EditNoteFragment
import kotlinx.android.synthetic.main.notes_fragment.*
import kotlinx.android.synthetic.main.notes_fragment_toolbar.*
import javax.inject.Inject

class NotesFragment : NavigationFragment(), NoteAdapter.OnNoteClickListener {

    @Inject lateinit var noteDiffUtilCallback: DiffUtil.ItemCallback<Note>

    override fun onNoteClick(note: Note) {
        openEditNoteScreen(note)
    }

    private fun openEditNoteScreen(note: Note) {
        navController.navigate(R.id.action_notesFragment_to_editNoteFragment, EditNoteFragment.newBundle(note))
    }

    private var notesViewModel: NotesViewModel? = null
    private lateinit var notesAdapter: NotePagingAdapter

    override fun layoutRes(): Int = R.layout.notes_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        initRecyclerView()
        initLiveData()
        initListeners()
    }

    private fun initLiveData() {
        if(notesViewModel != null) return
        notesViewModel = ViewModelProviders.of(this, viewModelFactory).get(NotesViewModel::class.java)
        notesViewModel!!.progressLiveData.observe(this, Observer { isShown -> displayProgress(isShown) })
        notesViewModel!!.notesPagedListLiveData.observe(this, Observer { pagedList -> setPagedList(pagedList) })
    }

    private fun setPagedList(pagedList: PagedList<Note>) {
        notesAdapter.submitList(pagedList)
    }

    private fun displayProgress(isShown: Boolean) {
        if(isShown) showProgress()
        else        hideProgress()
    }

    private fun initRecyclerView() {
        notesAdapter = NotePagingAdapter(noteDiffUtilCallback, this)
        notes_recycler_view.layoutManager = LinearLayoutManager(hostActivity, RecyclerView.VERTICAL, false)
        notes_recycler_view.adapter = notesAdapter
        notesViewModel?.initList()
    }

    override fun onStart() {
        super.onStart()
        notesViewModel?.start()
    }

    override fun onStop() {
        notesViewModel?.stop()
        super.onStop()
    }

    private fun initListeners() {
        notes_add_button.setOnClickListener { addNoteButtonClick() }
        notes_sort_button.setOnClickListener { showSortPopUpMenu(it) }
        search_notes_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            private val handler: Handler = Handler()

            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                handler.removeCallbacksAndMessages(null)
                handler.postDelayed({
                    newText?.let { notesViewModel?.setFilterPagedList(it) }
                }, 300)
                return true
            }

        })
    }

    private fun showSortPopUpMenu(v: View) {
        val sortMenu = PopupMenu(hostActivity, v)
        sortMenu.inflate(R.menu.sort_menu)
        sortMenu.setOnMenuItemClickListener { item ->
            when(item.itemId) {
                R.id.sort_asc -> {
                    notesViewModel?.setAscPagedList()
                    true
                }
                R.id.sort_desc -> {
                    notesViewModel?.setDescPagedList()
                    true
                }
                else -> false
            }
        }
        sortMenu.show()
    }

    private fun addNoteButtonClick() {
        navController.navigate(R.id.action_notesFragment_to_createNoteFragment)
    }
}