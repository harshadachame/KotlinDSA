package com.example.kotlindsa.LinkedList

// Node class for a generic linked list
data class Node<T>(var value: T, var next: Node<T>? = null)

class LinkedList<T> {
    private var head: Node<T>? = null

    // Check if the linked list is empty
    fun isEmpty(): Boolean = head == null

    // Add a new value to the linked list
    fun add(value: T) {
        val newNode = Node(value)
        if (head == null) {
            head = newNode
        } else {
            var current = head
            // Traverse the list until we find the last node
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    // Remove a node with a specific value
    fun remove(value: T) {
        var current = head
        var previous: Node<T>? = null

        // Find the node to remove
        while (current != null && current.value != value) {
            previous = current
            current = current.next
        }

        // If the node is found, remove it
        if (current == null) return

        if (previous == null) {
            head = current.next  // If the node is the first node
        } else {
            previous.next = current.next  // Bypass the node to remove it
        }
    }

    // Display all values in the linked list
    fun display() {
        var current = head
        while (current != null) {
            println(current.value)  // Print each value
            current = current.next
        }
    }
}

fun testLinkedList(){
    // Create a LinkedList instance of integers
    val linkedList = LinkedList<Int>()

    // Test 1: Add elements to the linked list
    linkedList.add(10)
    linkedList.add(20)
    linkedList.add(30)

    println("After adding elements:")
    linkedList.display() // Should display: 10, 20, 30

    // Test 2: Remove an element from the linked list
    linkedList.remove(20)

    println("After removing element 20:")
    linkedList.display() // Should display: 10, 30

    // Test 3: Remove element that doesn't exist
    linkedList.remove(50)

    println("After trying to remove element 50 (non-existing):")
    linkedList.display() // Should display: 10, 30

    // Test 4: Check if list is empty
    println("Is the list empty? ${linkedList.isEmpty()}") // Should return false

    // Test 5: Remove all elements
    linkedList.remove(10)
    linkedList.remove(30)

    println("After removing all elements:")
    linkedList.display() // Should display nothing
    println("Is the list empty? ${linkedList.isEmpty()}") // Should return true
}

fun main() {

    testLinkedList()
    testTaskList()      // Test TaskList
    testRecyclerViewList() // Test RecyclerViewList
    testHistoryList()      // Test HistoryList
    testRecentSearchList() // Test RecentSearchList

}

