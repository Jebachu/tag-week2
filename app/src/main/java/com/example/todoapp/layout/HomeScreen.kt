package com.example.todoapp.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.domain.Task
import com.example.todoapp.viewmodel.TaskViewModel

@Composable
fun HomeScreen(taskViewModel: TaskViewModel = viewModel()) {
    var newTaskTitle by remember { mutableStateOf("") }
    var filter by remember { mutableStateOf("Kaikki") }

    val tasks = when (filter) {
        "Valmiit" -> taskViewModel.tasks.filter { it.done }
        "Avoin" -> taskViewModel.tasks.filter { !it.done }
        else -> taskViewModel.tasks
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // Suodatusnapit
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Kaikki", "Valmiit", "Avoin").forEach { label ->
                Button(
                    onClick = { filter = label },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (filter == label) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    )
                ) { Text(label) }
            }
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { taskViewModel.sortByDueDate() }) {
                Text("Järjestä")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Uusi tehtävä
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                placeholder = { Text("Uusi tehtävä") },
                modifier = Modifier.weight(1f)
            )
            Button(
                onClick = {
                    if (newTaskTitle.isNotBlank()) {
                        val newTask = Task(
                            id = (taskViewModel.tasks.maxOfOrNull { it.id } ?: 0) + 1,
                            title = newTaskTitle,
                            description = "",
                            priority = 1,
                            dueDate = "2026-01-15",
                            done = false
                        )
                        taskViewModel.addTask(newTask)
                        newTaskTitle = ""
                    }
                }
            ) { Text("Lisää") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tehtävälista
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(tasks) { task ->
                TaskRow(task, onToggleDone = { taskViewModel.toggleDone(task.id) }, onDelete = { taskViewModel.removeTask(task.id) })
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, onToggleDone: () -> Unit, onDelete: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = task.done, onCheckedChange = { onToggleDone() })
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(task.title, style = MaterialTheme.typography.bodyLarge)
                Text("Eräpäivä: ${task.dueDate}", style = MaterialTheme.typography.bodySmall)
            }
        }
        Button(onClick = { onDelete() }) {
            Text("Poista")
        }
    }
}
