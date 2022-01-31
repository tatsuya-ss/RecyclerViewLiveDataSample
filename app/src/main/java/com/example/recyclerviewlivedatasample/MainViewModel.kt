package com.example.recyclerviewlivedatasample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val todoModel: Todo = Todo()): ViewModel() {

    val todo: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    fun addItem(item: String) {
        todoModel.add(item)
        todo.value = todoModel.getTodo()
    }

}