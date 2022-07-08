package com.wonderful.todo.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wonderful.todo.data.entity.Task
import com.wonderful.todo.data.repo.TodoRepository
import com.wonderful.todo.utils.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * Describe:
 * <p>
 * @author wonderful
 * @time 2022/7/8 14:42
 */
class MainViewModel(private val repository: TodoRepository = TodoRepository()) : ViewModel() {

    private val curTaskId: MutableState<Int> = mutableStateOf(0)
    val curTaskTitle: MutableState<String> = mutableStateOf("")
    val curTaskDesc: MutableState<String> = mutableStateOf("")
    val isCurTaskDone: MutableState<Boolean> = mutableStateOf(false)

    private val _allTasks = MutableStateFlow<RequestState<List<Task>>>(RequestState.IDLE)
    val allTask: StateFlow<RequestState<List<Task>>> = _allTasks

    private val _curTask: MutableStateFlow<Task?> = MutableStateFlow(null)
    val curTask: StateFlow<Task?> = _curTask

    init {
        loadAllTasks()
    }

    private fun loadAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks.onStart { _allTasks.value = RequestState.LOADING }
                .catch { _allTasks.value = RequestState.ERROR(it) }
                .collect { _allTasks.value = RequestState.SUCCESS(it) }
        }
    }

    fun searchTask(taskId: Int) {
        viewModelScope.launch {
            repository.searchTask(taskId)
                .catch { _curTask.value = null }
                .collect { _curTask.value = it }
        }
    }

    fun createTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val task = Task(title = curTaskTitle.value, desc = curTaskDesc.value, isDone = false)
            repository.insertTask(task = task)
        }
    }

    fun updateTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val task = Task(
                id = curTaskId.value,
                title = curTaskTitle.value,
                desc = curTaskDesc.value,
                isDone = isCurTaskDone.value
            )
            repository.updateTask(task = task)
        }
    }

    fun deleteTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val task = Task(
                id = curTaskId.value,
                title = curTaskTitle.value,
                desc = curTaskDesc.value,
                isDone = isCurTaskDone.value
            )
            repository.deleteTask(task)
        }
    }

    fun deleteAllTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTasks()
        }
    }

    fun updateCurTaskFields(curTask: Task?) {
        if (curTask != null) {
            curTaskId.value = curTask.id
            curTaskTitle.value = curTask.title
            curTaskDesc.value = curTask.desc
            isCurTaskDone.value = curTask.isDone
        } else {
            curTaskId.value = 0
            curTaskTitle.value = ""
            curTaskDesc.value = ""
            isCurTaskDone.value = false
        }
    }

    fun updateTitle(newTitle: String) {
        curTaskTitle.value = newTitle
    }

    fun isCurTaskValid(): Boolean {
        return curTaskTitle.value.isNotEmpty() && curTaskDesc.value.isNotEmpty()
    }
}