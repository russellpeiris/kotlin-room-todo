package com.mad.assignment.repository

import androidx.lifecycle.LiveData
import com.mad.assignment.model.Todo
import com.mad.assignment.dao.TodoDao

class TodoRepository(private val todoDao: TodoDao) {
    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    suspend fun delete(todo: Todo) {
        todoDao.delete(todo)
    }

    suspend fun update(todo: Todo) {
        todoDao.update(todo.id, todo.title, todo.description)
    }
}