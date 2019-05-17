package com.radik.labs.evo_test_project.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    var text: String = "",
    var createTimeMillis: Long = 0,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
) : Serializable
