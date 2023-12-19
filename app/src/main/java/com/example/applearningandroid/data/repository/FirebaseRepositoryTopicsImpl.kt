package com.example.applearningandroid.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.applearningandroid.data.model.Topic
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class FirebaseRepositoryTopicsImpl: RepositoryTopics {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference

    override suspend fun getTopicsByCategoryName(categoryName: String): LiveData<List<Topic>> {
        val liveData = MutableLiveData<List<Topic>>()

        databaseReference.child("Categories").child(categoryName).child("list_of_topics")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val topics = mutableListOf<Topic>()

                    for (topicSnapshot in snapshot.children) {
                        val topicId = topicSnapshot.child("id").getValue(Int::class.java)
                        val topicName = topicSnapshot.child("name").getValue(String::class.java)
                        //val topicContent = topicSnapshot.child("content").getValue(String::class.java)

                        if (topicName != null && topicId != null) {
                            val topic = Topic(topicId, topicName, "")
                            topics.add(topic)
                        }
                    }

                    liveData.value = topics
                    Log.d("FirebaseRepositoryTopics", "Loaded topics: $topics")
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("FirebaseRepositoryTopics", "Failed to load topics: $error")
                }
            })

        return liveData
    }
}