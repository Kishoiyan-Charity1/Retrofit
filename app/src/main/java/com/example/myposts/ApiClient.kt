package com.example.myposts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient{
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildAppClient(apiInterface:Class<T>): T{
        return retrofit.create(apiInterface)
    }

}