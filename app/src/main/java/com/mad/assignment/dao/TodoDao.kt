package com.mad.assignment.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mad.assignment.model.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

    @Query("SELECT * FROM todo_table order by id ASC")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("UPDATE todo_table SET title = :title, description = :description WHERE id = :id")
    suspend fun update(id: Int?, title: String?, description: String?)
}