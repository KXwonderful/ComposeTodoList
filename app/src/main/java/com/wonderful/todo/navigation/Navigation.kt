package com.wonderful.todo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.wonderful.todo.app.AppHolder
import com.wonderful.todo.ui.viewmodels.MainViewModel

/**
 * Describe: 导航 Composable
 * <p>
 * @author wonderful
 * @time 2022/7/8 14:32
 */

@Composable
fun SetupNavigation(navHostController: NavHostController, mainViewModel: MainViewModel) {
    val page = remember(navHostController) {
        Pages(navHostController = navHostController)
    }

    NavHost(navController = navHostController, startDestination = AppHolder.PAGE_SPLASH) {
        composable(route = AppHolder.PAGE_SPLASH) {
            // todo
        }

        composable(route = AppHolder.PAGE_HOME) {
            // todo
        }

        composable(
            route = AppHolder.PAGE_TASK_DETAIL,
            arguments = listOf(navArgument(AppHolder.TASK_ARG_KEY) {
                type = NavType.IntType
            })
        ) {
            // todo
        }
    }
}