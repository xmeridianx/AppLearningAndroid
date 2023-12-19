package com.example.applearningandroid.data.repository

import androidx.lifecycle.LiveData
import com.example.applearningandroid.data.model.Category

interface RepositoryCategories {
    suspend fun getCategories(): LiveData<List<Category>>
    //вернуть kotlin result
    //поменять название CategoriesRepository
    //или FirebaseCategoriesRepository
}