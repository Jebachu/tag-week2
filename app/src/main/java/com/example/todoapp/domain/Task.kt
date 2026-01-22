package com.example.todoapp.domain

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Int,
    val dueDate: String,
    val done: Boolean
)

fun addTask(list: List<Task>, task: Task): List<Task> =
    list + task

fun toggleDone(list: List<Task>, id: Int): List<Task> =
    list.map {
        if (it.id == id) it.copy(done = !it.done) else it
    }

fun filterByDone(list: List<Task>, done: Boolean): List<Task> =
    list.filter { it.done == done }

fun sortByDueDate(list: List<Task>): List<Task> =
    list.sortedBy { it.dueDate }
