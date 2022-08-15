package com.daffa.trynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.trynews.Network.MainViewModel
import com.daffa.trynews.Network.Response.NewsResponseItem
import com.daffa.trynews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding : ActivityMainBinding? =null
    private val binding get() = _binding as ActivityMainBinding

    private var _viewModel: MainViewModel? = null
    private val viewModel get() = _viewModel as MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        _viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(binding.root)

        viewModel.getNewsModels()
        viewModel.getListNews().observe(this){
            showData(it)
        }

    }

    private fun showData(data: List<NewsResponseItem>) {
    binding.rvNews.apply {
        layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = NewsAdapter(data)
    }
    }
}