package com.example.applearningandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applearningandroid.data.model.Topic
import com.example.applearningandroid.data.repository.FirebaseRepositoryTopicsImpl
import kotlinx.coroutines.launch

class TopicsViewModel: ViewModel() {
    private val repository = FirebaseRepositoryTopicsImpl()

    private val _topicsLiveData = MutableLiveData<List<Topic>>()
    val topicsLiveData: LiveData<List<Topic>> get() = _topicsLiveData

    fun getTopicsByCategoryName(categoryName: String) {
        viewModelScope.launch {
            repository.getTopicsByCategoryName(categoryName).observeForever {
                _topicsLiveData.postValue(it)
            }
        }
    }
}

/*
class TopicsViewModel: ViewModel() {
    private val repository = FirebaseRepositoryTopicsImpl()

    private val _topicsLiveData = MutableLiveData<List<Topic>>()
    val topicsLiveData: LiveData<List<Topic>> get() = _topicsLiveData

    fun loadTopicsByCategoryId(categoryId: Int) {
        viewModelScope.launch {
            repository.getTopicsByCategoryId(categoryId).observeForever {
                _topicsLiveData.postValue(it)
            }
        }
    }
}
 */