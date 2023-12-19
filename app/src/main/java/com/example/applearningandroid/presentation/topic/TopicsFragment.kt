package com.example.applearningandroid.presentation.topic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applearningandroid.data.model.Category
import com.example.applearningandroid.databinding.FragmentTopicsBinding
import com.example.applearningandroid.viewmodel.CategoriesViewModel
import com.example.applearningandroid.viewmodel.TopicsViewModel


class TopicsFragment : Fragment() {

    private lateinit var binding: FragmentTopicsBinding
    private lateinit var adapter: TopicsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopicsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(TopicsViewModel::class.java)
        adapter = TopicsAdapter()
        binding.recyclerViewTopics.adapter = adapter
        binding.recyclerViewTopics.layoutManager = LinearLayoutManager(requireContext())

        val category = arguments?.getSerializable("Category") as Category?

        if (category != null) {
            viewModel.getTopicsByCategoryName(category.name)
        }

        viewModel.topicsLiveData.observe(viewLifecycleOwner){
            adapter.setListTopics(it)
        }
    }
}