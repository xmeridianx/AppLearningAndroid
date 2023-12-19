package com.example.applearningandroid.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.applearningandroid.data.model.Category
import com.example.applearningandroid.data.model.Topic
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.tasks.await

class FirebaseRepositoryCategories: RepositoryCategories {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    override suspend fun getCategories(): LiveData<List<Category>> {
        val liveData = MutableLiveData<List<Category>>()

        try {
            val snapshot = databaseReference.child("Categories").get().await()
            val categories = mutableListOf<Category>()
            for (categorySnapshot in snapshot.children) {
                val categoryId = categorySnapshot.child("id").getValue(Int::class.java)
                val categoryName = categorySnapshot.child("name").getValue(String::class.java)
                val categoryTitle = categorySnapshot.child("title").getValue(String::class.java)


                val listOfTopicsSnapshot = categorySnapshot.child("list_of_topics")
                val listOfTopics = mutableListOf<Topic>()
                for (topicSnapshot in listOfTopicsSnapshot.children) {
                    val topicName = topicSnapshot.child("title").getValue(String::class.java)
                    if (topicName != null) {
                        val topic = Topic(name = topicName, id = 1, content = "")
                        listOfTopics.add(topic)
                    }
                }

                if (categoryName != null && categoryId != null && categoryTitle != null) {
                    val category = Category(categoryId, categoryName, categoryTitle)
                    categories.add(category)
                }
            }

            liveData.value = categories
        } catch (e: Exception) {
            // Обработка ошибки
        }
        return liveData

        /*
        databaseReference.child("Categories").addListenerForSingleValueEvent(object :
            ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val categories = mutableListOf<Category>()

                for (categorySnapshot in snapshot.children) {
                    val categoryId = categorySnapshot.child("id").getValue(Int::class.java)
                    val categoryName = categorySnapshot.child("name").getValue(String::class.java)
                    val categoryTitle = categorySnapshot.child("title").getValue(String::class.java)


                    val listOfTopicsSnapshot = categorySnapshot.child("list_of_topics")
                    val listOfTopics = mutableListOf<Topic>()
                    for (topicSnapshot in listOfTopicsSnapshot.children) {
                        val topicName = topicSnapshot.child("title").getValue(String::class.java)
                        if (topicName != null) {
                            val topic = Topic(name = topicName, id = 1, content = "")
                            listOfTopics.add(topic)
                        }
                    }

                    if (categoryName != null && categoryId != null && categoryTitle != null) {
                        val category = Category(categoryId, categoryName, categoryTitle)
                        categories.add(category)
                    }
                }

                liveData.value = categories
                Log.d("FirebaseRepository", "Loaded categories: $categories")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseRepository", "Failed to load categories: $error")
            }
        })

         */
    }
}
