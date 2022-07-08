package com.wonderful.todo.utils

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/4 10:51
 */
sealed interface RequestState<out T> {
    object IDLE : RequestState<Nothing>
    object LOADING : RequestState<Nothing>
    data class SUCCESS<T>(val data: T) : RequestState<T>
    data class ERROR(val error: Throwable) : RequestState<Nothing>
}