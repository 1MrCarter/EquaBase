package com.example.equabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubTopicViewModel : ViewModel() {

    private val _selectedCategory = MutableLiveData<CategoryType>()
    val selectedCategory: LiveData<CategoryType> = _selectedCategory

    private val _subTopics = MutableLiveData<List<SubCategoryType>>()
    val subTopics: LiveData<List<SubCategoryType>> = _subTopics

    fun setCategory(category: CategoryType) {
        _selectedCategory.value = category
        _subTopics.value = SubCategoryType.entries.filter { it.parent == category }
    }
}