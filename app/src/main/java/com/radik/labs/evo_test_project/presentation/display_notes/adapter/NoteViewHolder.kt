package com.radik.labs.evo_test_project.presentation.display_notes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.radik.labs.evo_test_project.model.Note
import com.radik.labs.evo_test_project.utils.toDate
import com.radik.labs.evo_test_project.utils.toTime
import kotlinx.android.synthetic.main.note_item_layout.view.*

class NoteViewHolder(
    itemView: View,
    private var note: Note,
    private var onNoteClickListener: NoteAdapter.OnNoteClickListener
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        onNoteClickListener.onNoteClick(this.note)
    }

    fun bind(note: Note) {
        this.note = note

        itemView.apply {
            note_date.text = toDate(note.createTimeMillis)
            note_time.text = toTime(note.createTimeMillis)

            note_text.text = note.text

        }
    }
}