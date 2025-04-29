package com.example.kotlindsa.LinkedList

// Node class to represent a search query
data class SearchNode(val query: String, var next: SearchNode? = null)

class RecentSearchList {
    private var head: SearchNode? = null

    // Add a new search query to the list
    fun addSearch(query: String) {
        val newSearch = SearchNode(query)
        if (head == null) {
            head = newSearch
        } else {
            var current = head
            // Traverse to the last search and add the new search
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newSearch
        }
    }

    // Display all recent searches
    fun displaySearches() {
        var current = head
        while (current != null) {
            println(current.query)
            current = current.next
        }
    }
}

// Testing the RecentSearchList class
fun testRecentSearchList() {
    val recentSearchList = RecentSearchList()

    // Add searches
    recentSearchList.addSearch("Kotlin")
    recentSearchList.addSearch("Android Development")
    recentSearchList.addSearch("Jetpack Compose")

    // Display recent searches
    println("Recent Searches:")
    recentSearchList.displaySearches()
}
