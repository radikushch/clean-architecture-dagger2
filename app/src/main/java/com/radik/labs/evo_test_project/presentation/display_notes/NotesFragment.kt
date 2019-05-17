package com.radik.labs.evo_test_project.presentation.display_notes

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.fragments.NavigationFragment
import com.radik.labs.evo_test_project.presentation.display_notes.adapter.NoteAdapter
import kotlinx.android.synthetic.main.notes_fragment.*

@FragmentScope
class NotesFragment : NavigationFragment(), NoteAdapter.OnNoteClickListener {

    override fun onNoteClick(note: Note) {
        openEditNoteScreen(note)
    }

    private fun openEditNoteScreen(note: Note) {
        val bundle = Bundle().apply {
            putSerializable(Note::class.java.simpleName, note)
        }
        navController.navigate(R.id.action_notesFragment_to_createNoteFragment, bundle)
    }

    private var notesViewModel: NotesViewModel? = null
    private lateinit var notesAdapter: NoteAdapter

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
        notesViewModel!!.notesLiveData.observe(this, Observer {notes -> updateNotesList(notes) })
        notesViewModel!!.progressLiveData.observe(this, Observer { isShown -> displayProgress(isShown) })
    }

    private fun displayProgress(isShown: Boolean) {
        if(isShown) showProgress()
        else        hideProgress()
    }

    private fun updateNotesList(notes: List<Note>) {
        notesAdapter.swapData(notes)
    }

    private fun initRecyclerView() {
        notesAdapter = NoteAdapter(ArrayList(), this)
        notes_recycler_view.layoutManager = LinearLayoutManager(hostActivity, RecyclerView.VERTICAL, false)
        notes_recycler_view.adapter = notesAdapter
    }

    override fun onStart() {
        super.onStart()
        notesViewModel?.start()
    }

    override fun onStop() {
        super.onStop()
        notesViewModel?.stop()
    }

    private fun initListeners() {
        notes_add_button.setOnClickListener { addNoteButtonClick() }
    }

    private fun addNoteButtonClick() {
        navController.navigate(R.id.action_notesFragment_to_createNoteFragment)
    }
}