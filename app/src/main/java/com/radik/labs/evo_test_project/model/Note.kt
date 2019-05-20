package com.radik.labs.evo_test_project.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity
data class Note(
    var text: String = "",
    var createTimeMillis: Long = 0,
    @PrimaryKey(autoGenerate = true) var id: Long = 0
) : Serializable {

    override fun equals(other: Any?): Boolean {
        return when {
            other == null -> false
            other !is Note -> false
            this.text != other.text -> false
            else -> this.createTimeMillis == other.createTimeMillis
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(createTimeMillis, text)
    }
}
