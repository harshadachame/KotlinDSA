package com.example.kotlindsa.LinkedList

// Node class to represent a list item
data class ListItem(val name: String, var next: ListItem? = null)

class RecyclerViewList {
    private var head: ListItem? = null

    // Add a new item to the list
    fun addItem(name: String) {
        val newItem = ListItem(name)
        if (head == null) {
            head = newItem
        } else {
            var current = head
            // Traverse to the last item and add the new item
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newItem
        }
    }

    // Display all items in the list
    fun displayItems() {
        var current = head
        while (current != null) {
            println(current.name)
            current = current.next
        }
    }

    // Simulate data binding with RecyclerView (print all items)
    fun updateRecyclerView() {
        var current = head
        val items = mutableListOf<String>()
        while (current != null) {
            items.add(current.name)
            current = current.next
        }
        // Simulate updating RecyclerView
        println("RecyclerView updated with items: ${items.joinToString(", ")}")
    }
}

// Testing the RecyclerViewList class
fun testRecyclerViewList() {
    val recyclerViewList = RecyclerViewList()

    // Add items
    recyclerViewList.addItem("Item 1")
    recyclerViewList.addItem("Item 2")
    recyclerViewList.addItem("Item 3")

    // Display items
    println("Items in RecyclerView:")
    recyclerViewList.displayItems()

    // Update RecyclerView (simulate)
    recyclerViewList.updateRecyclerView()
}
