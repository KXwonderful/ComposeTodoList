package com.wonderful.todo.data.db

import androidx.room.Room
import com.wonderful.todo.app.AppHolder

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/4 10:32
 */
object DBHelper {

    private fun provideRoomDB() = Room.databaseBuilder(
        AppHolder.appContext,
        TodoDatabase::class.java,
        AppHolder.DB_NAME
    ).build()

    fun provideDao(database: TodoDatabase = provideRoomDB()) = database.todoDao()
}