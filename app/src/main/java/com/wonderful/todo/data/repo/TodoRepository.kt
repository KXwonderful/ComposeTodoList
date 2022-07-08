package com.wonderful.todo.data.repo

import com.wonderful.todo.data.db.DBHelper
import com.wonderful.todo.data.db.TodoDao
import com.wonderful.todo.data.entity.Task
import kotlinx.coroutines.flow.Flow

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/4 10:54
 */
class TodoRepository(private val todoDao: TodoDao = DBHelper.provideDao()) {

    val getAllTasks: Flow<List<Task>> = todoDao.loadAllTasks()

    fun searchTask(taskId: Int): Flow<Task> = todoDao.searchTask(taskId)

    suspend fun insertTask(task: Task) = todoDao.insertTask(task)

    suspend fun updateTask(task: Task) = todoDao.updateTask(task)

    suspend fun deleteTask(task: Task) = todoDao.deleteTask(task)

    suspend fun deleteAllTasks() = todoDao.deleteAllTasks()
}