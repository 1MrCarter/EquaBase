package com.example.equabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _categories = MutableLiveData<List<CategoryType>>()
    val categories: LiveData<List<CategoryType>> = _categories

    init {
        _categories.value = CategoryType.entries.toList()
    }
}