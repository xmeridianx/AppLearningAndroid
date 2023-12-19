package com.example.applearningandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applearningandroid.R
import com.example.applearningandroid.data.TestBase
import com.example.applearningandroid.databinding.ActivityMainBinding
import com.example.applearningandroid.presentation.category.CategoriesFragment

class MainActivity : AppCompatActivity() {
    private val testAdmin = TestBase()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.container, CategoriesFragment())
            .commit()
        /*
        binding.buttonAddContentToDatabase.setOnClickListener {
            testAdmin.test()
        }
        */
    }



}