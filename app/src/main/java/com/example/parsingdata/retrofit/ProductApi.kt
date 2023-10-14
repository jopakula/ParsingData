package com.example.parsingdata.retrofit

import retrofit2.http.GET

interface ProductApi {
    @GET("/")
    suspend fun getAllProduct(): Products
}