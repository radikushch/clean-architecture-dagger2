package com.radik.labs.evo_test_project.presentation.display_notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radik.labs.evo_test_project.R
import com.radik.labs.evo_test_project.model.Note

class NoteAdapter(
    private var data: MutableList<Note>,
    private var onNoteCLickListener: OnNoteClickListener
) : RecyclerView.Adapter<NoteViewHolder>() {

    interface OnNoteClickListener {
        fun onNoteClick(note: Note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item_layout, parent, false)
        return NoteViewHolder(view, data[viewType], onNoteCLickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun swapData(notes: List<Note>) {
        data.clear()
        data.addAll(notes)
        notifyDataSetChanged()
    }
}