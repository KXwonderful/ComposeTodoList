package com.wonderful.todo.app

import android.app.Application

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/1 17:15
 */
class TodoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        AppHolder.appContext = this
    }
}