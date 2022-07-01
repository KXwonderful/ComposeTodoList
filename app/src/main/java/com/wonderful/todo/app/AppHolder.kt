package com.wonderful.todo.app

import android.app.Application

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/1 17:16
 */
object AppHolder {
    const val SPLASH_DELAY = 3000L

    const val PAGE_SPLASH = "splash"
    const val PAGE_HOME = "home"
    const val TASK_DETAIL_BASE = "task_detail/"
    const val TASK_ARG_KEY = "taskId"
    const val PAGE_TASK_DETAIL = "${TASK_DETAIL_BASE}{${TASK_ARG_KEY}}"

    const val DB_TABLE = "todo_table"
    const val DB_NAME = "db_todo"

    lateinit var appContext: Application
}