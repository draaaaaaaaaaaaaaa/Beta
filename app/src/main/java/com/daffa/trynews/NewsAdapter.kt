package com.daffa.trynews

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.trynews.Network.Response.NewsResponseItem
import com.daffa.trynews.databinding.RowItemNewsBinding

class NewsAdapter(private val listNews: List<NewsResponseItem>) :
RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: RowItemNewsBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        RowItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply {
        tvTitle.text = data.title
        tvDate.text = data.time
        tvSource.text = data.author
            tvDetail.text = data.desc
            Glide.with(imgContent.context).load(data.thumb).into(imgContent)
        }
    }

    override fun getItemCount(): Int = listNews.size
}

