package com.mad.assignment.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize

@Entity(tableName = "task_table")
data class TaskEntry(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val priority: Int,
    val timestamp: Long,
) : Parcelable
