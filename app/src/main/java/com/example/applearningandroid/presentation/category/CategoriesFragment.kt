package com.example.applearningandroid.presentation.category

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applearningandroid.R
import com.example.applearningandroid.data.TestBase
import com.example.applearningandroid.data.model.Category
import com.example.applearningandroid.databinding.FragmentCategoriesBinding
import com.example.applearningandroid.presentation.topic.TopicsFragment
import com.example.applearningandroid.viewmodel.CategoriesViewModel


class CategoriesFragment : Fragment(){

    private lateinit var binding: FragmentCategoriesBinding
    private lateinit var adapter: CategoriesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createAdapter()
        binding.recyclerViewCategories.adapter = adapter
        binding.recyclerViewCategories.layoutManager = LinearLayoutManager(requireContext())
        val viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)

        viewModel.categoriesLiveData.observe(viewLifecycleOwner) { categoryList ->
            if (categoryList != null) {
                adapter.setListCategories(categoryList.sortedBy { it.id })
            }
            //sortedBy во viewmodel
        }
        viewModel.loadCategories()

        val htmlString = "<br/> Это <font color='#ff0000'>Курс по Android Разработке.</font>"
        binding.textViewMainFragment.text = Html.fromHtml(htmlString, Html.FROM_HTML_MODE_COMPACT)

        //отправляю данные в firebase
        binding.buttonAddContentToDatabase.setOnClickListener {
            TestBase().test()
        }
    }

    private fun createAdapter() {
        adapter = CategoriesAdapter(object:(Category)-> Unit{
            override fun invoke(category: Category) {
                val topicsFragment = TopicsFragment()
                topicsFragment.arguments = bundleOf("Category" to category)

                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, topicsFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        })
    }
}