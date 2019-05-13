package com.radik.labs.evo_test_project.presentation.create_note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.presentation.base.ToolbarFragment
import kotlinx.android.synthetic.main.add_note_fragment.*
import kotlinx.android.synthetic.main.add_note_fragment_toolbar.*
import javax.inject.Inject

@FragmentScope
class CreateNoteFragment : ToolbarFragment() {

    @Inject
    lateinit var crateNoteViewModel: CreateNoteViewModel

    override fun toolbarLayoutRes(): Int = R.layout.add_note_fragment_toolbar

    override fun layoutRes(): Int  = R.layout.add_note_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        hostToolbarActivity?.let{activity ->
            activity.apply {
                add_note_back_button.setOnClickListener { backButtonClick() }
            }
        }
    }

    private fun backButtonClick() {
        hostToolbarActivity?.onBackPressed()
    }

    override fun onStop() {
        super.onStop()
        crateNoteViewModel.addNote(add_note_edit_text.text.toString())
    }
}