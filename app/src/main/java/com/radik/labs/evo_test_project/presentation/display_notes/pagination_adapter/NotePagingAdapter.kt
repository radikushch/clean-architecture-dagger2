package com.radik.labs.evo_test_project.presentation.display_notes.pagination_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.presentation.display_notes.adapter.NoteAdapter
import com.radik.labs.evo_test_project.presentation.display_notes.adapter.NoteViewHolder
import javax.inject.Inject

class NotePagingAdapter @Inject constructor(
    diffUtilCallback: DiffUtil.ItemCallback<Note>,
    private var onNoteCLickListener: NoteAdapter.OnNoteClickListener
) : PagedListAdapter<Note, NoteViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item_layout, parent, false)
        return NoteViewHolder(view, getItem(viewType)!!, onNoteCLickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }
}