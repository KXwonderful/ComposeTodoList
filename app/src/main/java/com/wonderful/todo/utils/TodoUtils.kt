package com.wonderful.todo.utils

import android.widget.Toast
import com.wonderful.todo.app.AppHolder

/**
 * Describe: 工具类
 * <p>
 * @author wonderful
 * @time 2022/7/4 10:47
 */

fun String.showToast() {
    Toast.makeText(AppHolder.appContext, this, Toast.LENGTH_SHORT).show()
}