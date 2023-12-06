package com.mad.assignment.repository

import androidx.lifecycle.LiveData
import com.mad.assignment.database.TaskDao
import com.mad.assignment.database.TaskEntry

class TaskRepository(val taskDao: TaskDao) {

    suspend fun insert(taskEntry: TaskEntry) {
        taskDao.insert(taskEntry)
    }

    suspend fun deleteItem(taskEntry: TaskEntry) {
        taskDao.delete(taskEntry)
    }

    suspend fun updateData(taskEntry: TaskEntry) {
        taskDao.update(taskEntry)
    }

    suspend fun deleteAll() {
        taskDao.deleteAll()
    }

    fun getAllTasks() : LiveData<List<TaskEntry>> = taskDao.getAllTasks()
}