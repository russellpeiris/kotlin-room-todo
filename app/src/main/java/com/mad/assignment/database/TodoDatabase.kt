package com.mad.assignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mad.assignment.model.Todo
import com.mad.assignment.dao.TodoDao

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun getTodoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }

}