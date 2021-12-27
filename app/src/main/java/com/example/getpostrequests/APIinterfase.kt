package com.example.getpostrequests

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIinterfase {

    @GET("/custom-people/?format=json")
    fun getName(): Call<List<Person.myDataItem>>

    @POST("/custom-people/?format=json")
    fun postName(@Body info:Person.myDataItem): Call<Person.myDataItem>
}