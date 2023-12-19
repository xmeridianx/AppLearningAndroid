package com.example.applearningandroid.presentation.category

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applearningandroid.R
import com.example.applearningandroid.data.model.Category

class CategoriesAdapter(private val listener: (Category)-> Unit):
    RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>() {
    private val categories = mutableListOf<Category>()

    class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val categoryTextView: TextView = itemView.findViewById(R.id.textViewCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.categoryTextView.text = categories[position].title

        holder.itemView.setOnClickListener {
            listener(categories[position])
        }
    }

    fun setListCategories(list: List<Category>){
        categories.addAll(list)
        notifyDataSetChanged()
    }

}