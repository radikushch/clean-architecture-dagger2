package com.radik.labs.evo_test_project.presentation.edit_note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.fragments.NavigationFragment

@FragmentScope
class EditNoteFragment : NavigationFragment() {

    override fun layoutRes(): Int = R.layout.edit_note_fragment

    private var editNoteViewModel: EditNoteViewModel? = null

    companion object {
        private const val NOTE_KEY= "note"

        fun newBundle(note: Note) : Bundle {
            return Bundle().apply {
                putSerializable(NOTE_KEY, note)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onStart() {
        super.onStart()
        editNoteViewModel?.start()
    }

    override fun onStop() {
        super.onStop()
        editNoteViewModel?.stop()
    }

    private fun init() {
        initViewModel()
    }

    private fun initViewModel() {
        if(editNoteViewModel != null) return
        editNoteViewModel = ViewModelProviders.of(this, viewModelFactory).get(EditNoteViewModel::class.java)
    }

    private fun getBundleNote(): Note? {
        arguments?.let {
            return@getBundleNote it.getSerializable(NOTE_KEY) as Note?
        }
        return null
    }
}