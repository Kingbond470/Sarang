package com.example.sarang.view.itunes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApiService {
    @GET("search")
    fun getData(@Query("term") term:String): Call<ITunesResponse>
}