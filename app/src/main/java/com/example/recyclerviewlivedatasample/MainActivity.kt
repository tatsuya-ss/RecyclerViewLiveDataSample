package com.example.recyclerviewlivedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewlivedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupRecyclerView()
        setupViewModel()
        setupButton()

    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupButton() {
        binding.button.setOnClickListener {
            viewModel.addItem("追加")
        }
    }

    private fun setupRecyclerView() {
        binding.RecyclerView.adapter = RecyclerViewAdapter()
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupViewModel() {
        viewModel.todo.observe(this, Observer {
            val adapter = binding.RecyclerView.adapter as RecyclerViewAdapter
            adapter.setItem(it)
            println("debug, $it")
        })
    }
}