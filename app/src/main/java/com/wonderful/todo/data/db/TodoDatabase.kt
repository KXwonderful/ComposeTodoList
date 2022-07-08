package com.wonderful.todo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wonderful.todo.data.entity.Task

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/4 10:37
 */
@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}