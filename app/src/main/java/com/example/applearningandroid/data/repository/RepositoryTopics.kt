package com.example.applearningandroid.data.repository

import androidx.lifecycle.LiveData
import com.example.applearningandroid.data.model.Topic

interface RepositoryTopics {
    suspend fun getTopicsByCategoryName(categoryName: String): LiveData<List<Topic>>
}