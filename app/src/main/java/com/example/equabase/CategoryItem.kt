package com.example.equabase

sealed class CategoryItem(val title: String){
    class Category(val type: CategoryType) : CategoryItem(type.title)
    class SubCategory(val type: SubCategoryType) : CategoryItem(type.title)
}