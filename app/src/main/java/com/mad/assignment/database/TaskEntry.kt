package com.mad.assignment.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntry(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val priority: Int,
    val timestamp: Long,
)
