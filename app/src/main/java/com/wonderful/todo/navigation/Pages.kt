package com.wonderful.todo.navigation

import androidx.navigation.NavHostController
import com.wonderful.todo.app.AppHolder

/**
 * Describe: 页面跳转
 * <p>
 * @author wonderful
 * @time 2022/7/8 15:37
 */
class Pages(navHostController: NavHostController) {
    val gotoHomeFromSplash: () -> Unit = {
        navHostController.navigate(route = AppHolder.PAGE_HOME) {
            popUpTo(AppHolder.PAGE_SPLASH) { inclusive = true }
        }
    }

    val gotoTaskDetail: (Int) -> Unit = { taskId ->
        navHostController.navigate(route = "${AppHolder.TASK_DETAIL_BASE}$taskId")
    }

    val gotoHomePage: () -> Unit = {
        navHostController.navigate(route = AppHolder.PAGE_HOME) {
            popUpTo(AppHolder.PAGE_HOME) { inclusive = true }
        }
    }
}