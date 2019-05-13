package com.radik.labs.evo_test_project.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    var text: String,
    var createTimeMillis: Long,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)
