package com.radik.labs.evo_test_project.pagination

import androidx.recyclerview.widget.DiffUtil
import com.radik.labs.evo_test_project.model.Note

class NoteDiffUtilCallback : DiffUtil.ItemCallback<Note>() {


    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}