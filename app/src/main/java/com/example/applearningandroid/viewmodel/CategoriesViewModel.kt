package com.example.applearningandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applearningandroid.data.model.Category
import com.example.applearningandroid.data.repository.FirebaseRepositoryCategories
import kotlinx.coroutines.launch

class CategoriesViewModel() : ViewModel() {
    //repository закинуть в констурктор
    private val repository = FirebaseRepositoryCategories()


    private val _categoriesLiveData = MutableLiveData<List<Category>>()
    val categoriesLiveData: LiveData<List<Category>> get() = _categoriesLiveData

    fun loadCategories() {
        viewModelScope.launch {
            repository.getCategories().observeForever {
                _categoriesLiveData.postValue(it)
            }
        }
    }
}

/*
//добавить state
 val categoriesLiveData: LiveData<List<Category>> = repository.getCategories()


val categoriesLiveData: LiveDate<List<Category>> = liveData {
   emit(repository.getCategories())
}
 */
