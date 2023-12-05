package com.mad.assignment.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mad.assignment.repository.TodoRepository
import com.mad.assignment.database.TodoDatabase
import com.mad.assignment.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application){
    private val repository: TodoRepository
    val allTodos: LiveData<List<Todo>>

    init {
        val dao = TodoDatabase.getDatabase(application).getTodoDao()
        repository = TodoRepository(dao)
        allTodos = repository.allTodos
    }

    fun insertTodo(todo: Todo) = viewModelScope.launch (Dispatchers.IO) {
        repository.insert(todo)
    }

    fun deleteTodo(todo: Todo) = viewModelScope.launch (Dispatchers.IO) {
        repository.delete(todo)
    }

    fun updateTodo(todo: Todo) = viewModelScope.launch (Dispatchers.IO) {
        repository.update(todo)
    }
}