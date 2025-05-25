package com.example.equabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryItemViewModel : ViewModel() {
    private val _items = MutableLiveData<List<CategoryItem>>()
    val items : LiveData<List<CategoryItem>> = _items

    fun loadCategories(){
        _items.value = CategoryType.entries.map { CategoryItem.Category(it) }
    }
    fun loadSubCategories(parent: CategoryType) {
        _items.value = SubCategoryType.entries.filter { it.parent == parent }.map { CategoryItem.SubCategory(it) }
    }
}