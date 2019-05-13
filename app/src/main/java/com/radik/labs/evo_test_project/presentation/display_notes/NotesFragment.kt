package com.radik.labs.evo_test_project.presentation.display_notes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.presentation.base.ToolbarFragment
import com.radik.labs.evo_test_project.di.ViewModelFactory
import com.radik.labs.evo_test_project.model.Note
import kotlinx.android.synthetic.main.notes_fragment.*
import javax.inject.Inject

class NotesFragment : ToolbarFragment(){

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var notesViewModel: NotesViewModel

    override fun toolbarLayoutRes(): Int = R.layout.notes_fragment_toolbar

    override fun layoutRes(): Int = R.layout.notes_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = ViewModelProviders.of(this, viewModelFactory).get(NotesViewModel::class.java)
        initViews()
        notesViewModel.create()
        notesViewModel.resLiveData.observe(this, Observer {t(it)})
    }

    @SuppressLint("SetTextI18n")
    private fun t(list: List<Note>) {
        var str = ""
        list.forEach {
            str  += it.toString() + "\n"
        }
        test.text = str
    }

    private fun initViews() {
        notes_add_button.setOnClickListener { addNoteButtonClick() }
    }

    private fun addNoteButtonClick() {
        navController.navigate(R.id.action_notesFragment_to_createNoteFragment)
    }
}