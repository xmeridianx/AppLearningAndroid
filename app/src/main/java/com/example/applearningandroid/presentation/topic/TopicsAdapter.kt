package com.example.applearningandroid.presentation.topic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applearningandroid.R
import com.example.applearningandroid.data.model.Topic

class TopicsAdapter():
    //потом добавить в конструктор
    //private val listener: OnTopicItemClickListener
    RecyclerView.Adapter<TopicsAdapter.TopicsViewHolder>() {

    private val topics = mutableListOf<Topic>()

    class TopicsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val topicTextView: TextView = itemView.findViewById(R.id.textViewTopic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_topic, parent, false)
        return TopicsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: TopicsViewHolder, position: Int) {
        holder.topicTextView.text = topics[position].name

        holder.itemView.setOnClickListener {
            //  listener.onItemClick(topics[position])
        }
    }

    fun setListTopics(list: List<Topic>){
        topics.addAll(list)
        notifyDataSetChanged()
    }
}