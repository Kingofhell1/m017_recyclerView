package com.example.m017_recyclerview.data

import android.content.Context
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.example.m017_recyclerview.data.ConstData



class Retrofit(applicationContext: Context?){


    private val moshi =
        Moshi.Builder().addLast(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
            .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(ConstData.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val getPhotos: NasaPhotosApi = retrofit.create(NasaPhotosApi::class.java)
}
interface NasaPhotosApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )
    @GET("photos")
    suspend fun getPhotos(
        @Query("sol") sol: Int,
        @Query("api_key") api_key: String
   ): Response<ResultDto>?


}
