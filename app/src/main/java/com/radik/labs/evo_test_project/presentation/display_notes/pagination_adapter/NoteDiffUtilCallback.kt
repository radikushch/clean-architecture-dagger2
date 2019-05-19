package com.radik.labs.evo_test_project.presentation.display_notes.pagination_adapter

import androidx.recyclerview.widget.DiffUtil
import com.radik.labs.evo_test_project.di.scopes.ActivityScope
import com.radik.labs.evo_test_project.model.Note
import javax.inject.Inject

@ActivityScope
class NoteDiffUtilCallback @Inject constructor() : DiffUtil.ItemCallback<Note>() {


    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }
}