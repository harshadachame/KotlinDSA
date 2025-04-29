package com.example.kotlindsa.LinkedList

// Node class for representing a page visit or action
data class HistoryNode(val page: String, var next: HistoryNode? = null)

class HistoryList {
    private var head: HistoryNode? = null

    // Add a new page to history
    fun addHistory(page: String) {
        val newPage = HistoryNode(page)
        if (head == null) {
            head = newPage
        } else {
            var current = head
            // Traverse to the last page and add the new page
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newPage
        }
    }

    // Remove a specific page from history
    fun removeHistory(page: String) {
        var current = head
        var previous: HistoryNode? = null

        if (current?.page == page) {
            head = current.next  // Remove the first page
            return
        }

        while (current != null && current.page != page) {
            previous = current
            current = current.next
        }

        // If page found, remove it
        if (current != null) {
            previous?.next = current.next
        }
    }

    // Display all pages in history
    fun displayHistory() {
        var current = head
        while (current != null) {
            println(current.page)
            current = current.next
        }
    }
}

// Testing the HistoryList class
fun testHistoryList() {
    val historyList = HistoryList()

    // Add pages to history
    historyList.addHistory("Home Page")
    historyList.addHistory("Profile Page")
    historyList.addHistory("Settings Page")

    // Display history
    println("History:")
    historyList.displayHistory()

    // Remove a page from history
    historyList.removeHistory("Profile Page")
    println("\nHistory after removing Profile Page:")
    historyList.displayHistory()
}
