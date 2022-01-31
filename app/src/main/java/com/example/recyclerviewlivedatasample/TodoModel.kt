package com.example.recyclerviewlivedatasample

class Todo(private var todos: MutableList<String> = mutableListOf<String>()) {

    fun getTodo(): List<String> {
        return todos
    }

    fun add(todo: String) {
        todos.add(todo)
    }

}