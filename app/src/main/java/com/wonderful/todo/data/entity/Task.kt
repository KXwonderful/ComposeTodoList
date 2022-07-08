package com.wonderful.todo.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wonderful.todo.app.AppHolder

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/4 10:35
 */
@Entity(tableName = AppHolder.DB_TABLE)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val desc: String,
    val isDone: Boolean
)
