package com.pdm.paging.Retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://taller2-a645b.firebaseio.com/"

interface ImageService {

    @GET("images.json")
    fun getImages():Deferred<Response<Images>>

    companion object {
        fun getMovieService():ImageService= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build().create(ImageService::class.java)
    }

}