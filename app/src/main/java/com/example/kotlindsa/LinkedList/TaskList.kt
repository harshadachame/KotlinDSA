package com.example.kotlindsa.LinkedList

// Node class to represent each task
data class TaskNode(var task: String, var next: TaskNode? = null)

class TaskList {
    private var head: TaskNode? = null

    // Add a new task to the list
    fun addTask(task: String) {
        val newTask = TaskNode(task)
        if (head == null) {
            head = newTask
        } else {
            var current = head
            // Traverse until the last task and add the new task
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newTask
        }
    }

    // Remove a specific task from the list
    fun removeTask(taskName: String) {
        var current = head
        var previous: TaskNode? = null

        // Find the task to remove
        if (current?.task == taskName) {
            head = current.next  // If it's the first task, remove it
            return
        }

        while (current != null && current.task != taskName) {
            previous = current
            current = current.next
        }

        // If task found, remove it
        if (current != null) {
            previous?.next = current.next
        }
    }

    // Display all tasks
    fun displayTasks() {
        var current = head
        while (current != null) {
            println(current.task)
            current = current.next
        }
    }
}

// Testing the TaskList class
fun testTaskList() {
    val taskList = TaskList()

    // Add tasks
    taskList.addTask("Task 1")
    taskList.addTask("Task 2")
    taskList.addTask("Task 3")

    // Display tasks
    println("Tasks in the list:")
    taskList.displayTasks()

    // Remove a task
    taskList.removeTask("Task 2")
    println("\nTasks after removing Task 2:")
    taskList.displayTasks()
}
