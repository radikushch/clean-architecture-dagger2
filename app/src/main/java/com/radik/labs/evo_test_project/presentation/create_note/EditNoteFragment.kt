package com.radik.labs.evo_test_project.presentation.create_note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.presentation.base.fragments.BaseFragment

class EditNoteFragment : BaseFragment() {

    private lateinit var crateNoteViewModel: CreateNoteViewModel

    override fun layoutRes(): Int  = R.layout.add_note_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crateNoteViewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateNoteViewModel::class.java)
    }
}