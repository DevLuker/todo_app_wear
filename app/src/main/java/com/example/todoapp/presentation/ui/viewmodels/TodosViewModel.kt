package com.example.todoapp.presentation.ui.viewmodels


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel


class TodosViewModel : ViewModel() {

    var stringList =  mutableStateListOf<String>()

    fun addItemToList(item: String) {
        stringList.add(item)
    }

    fun removeItemFromList(item: String) {
        stringList.remove(item)
    }

}