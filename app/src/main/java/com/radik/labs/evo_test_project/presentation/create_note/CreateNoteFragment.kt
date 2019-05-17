package com.radik.labs.evo_test_project.presentation.create_note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.BaseViewModel
import com.radik.labs.evo_test_project.presentation.base.fragments.BaseFragment
import com.radik.labs.evo_test_project.presentation.base.fragments.NavigationFragment
import com.radik.labs.evo_test_project.presentation.edit_note.EditNoteViewModel
import kotlinx.android.synthetic.main.add_note_fragment.*
import kotlinx.android.synthetic.main.add_note_fragment_toolbar.*

class CreateNoteFragment : NavigationFragment() {

    private var createNoteViewModel: CreateNoteViewModel? = null

    override fun layoutRes(): Int  = R.layout.add_note_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onStart() {
        super.onStart()
        createNoteViewModel?.start()
    }

    override fun onStop() {
        createNoteViewModel?.stop()
        super.onStop()
    }

    private fun init() {
        initViewModel()
        initListeners()
    }

    private fun initListeners() {
        add_note_back_button.setOnClickListener { backButtonClick() }
        add_note_button.setOnClickListener { saveNoteButtonClick() }
    }

    private fun saveNoteButtonClick() {
        val noteText = add_note_edit_text.text.toString()
        if(noteText.isEmpty()) return
        createNoteViewModel?.saveNote(noteText)
    }

    private fun backButtonClick() {
        hostActivity?.onBackPressed()
    }

    private fun initViewModel() {
        if(createNoteViewModel != null) return
        createNoteViewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateNoteViewModel::class.java)
    }
}