package com.radik.labs.evo_test_project.presentation.edit_note

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.radik.labs.evo_test_project.di.scopes.FragmentScope
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.base.fragments.NavigationFragment
import kotlinx.android.synthetic.main.edit_note_fragment.*
import kotlinx.android.synthetic.main.edit_note_fragment_toolbar.*
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.Observer
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.model.StorageResponse


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
        edit_note_edit.setText(getBundleNote()?.text ?: "")
        initViewModel()
        initListeners()
    }

    private fun initListeners() {
        edit_note_back_button.setOnClickListener { backButtonClick() }
        edit_note_remove_button.setOnClickListener { removeNoteButtonClick() }
        edit_note_share_button.setOnClickListener { shareButtonClick() }
        edit_note_button.setOnClickListener { editButtonClick() }
    }

    private fun editButtonClick() {
        if(!edit_note_edit.isEnabled) {
            edit_note_edit.isEnabled = true
            edit_note_button.text = hostActivity?.resources?.getString(R.string.save)
        }else {
            edit_note_edit.isEnabled = false
            edit_note_button.text = hostActivity?.resources?.getString(R.string.edit)
            editNoteViewModel?.updateNote(edit_note_edit.text.toString(), getBundleNote() ?: Note())
        }
    }

    private fun shareButtonClick() {
        getBundleNote()?.let { shareNote(it) }
    }

    private fun shareNote(note: Note) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, note.text)
        startActivity(Intent.createChooser(sharingIntent, resources.getString(R.string.share_using)))
    }

    private fun removeNoteButtonClick() {
        getBundleNote()?.let { editNoteViewModel?.removeNote(it) }
    }

    private fun backButtonClick() {
        hostActivity?.onBackPressed()
    }

    private fun initViewModel() {
        if(editNoteViewModel != null) return
        editNoteViewModel = ViewModelProviders.of(this, viewModelFactory).get(EditNoteViewModel::class.java)
        editNoteViewModel!!.completeLiveData.observe(this, Observer { response -> showCompleteMessage(response) })
        editNoteViewModel!!.errorLiveData.observe(this, Observer { message -> showErrorMessage(message) })
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(hostActivity, message, Toast.LENGTH_SHORT).show()
    }

    private fun showCompleteMessage(response: Pair<StorageResponse, String>) {
        when(response.first) {
            StorageResponse.DELETE -> {
                hostActivity?.onBackPressed()
            }
        }
        Toast.makeText(hostActivity, response.second, Toast.LENGTH_SHORT).show()
    }

    private fun getBundleNote(): Note? {
        arguments?.let {
            return@getBundleNote it.getSerializable(NOTE_KEY) as Note?
        }
        return null
    }
}