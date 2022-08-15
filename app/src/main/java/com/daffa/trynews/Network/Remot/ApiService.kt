package com.daffa.trynews.Network.Remot

import com.daffa.trynews.Network.Response.NewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("api/games/lazy-talk")
    fun getNews() : Call<List<NewsResponseItem>>
}