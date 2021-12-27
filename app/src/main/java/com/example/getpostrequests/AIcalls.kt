package com.example.getpostrequests

import android.app.Activity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AIcalls {
    companion object {
        val apiInterface = APIclint().getClient()?.create(APIinterfase::class.java)

        fun postName(name: String, activity: Activity) {
            apiInterface?.postName(Person.myDataItem(name, 1))?.enqueue(object:Callback<Person.myDataItem?> {
                override fun onResponse(call: Call<Person.myDataItem?>,response: Response<Person.myDataItem?>) {
                    Toast.makeText(activity, "$name: your name has added successfully", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<Person.myDataItem?>, t: Throwable) {
                    Toast.makeText(activity, "$t error ", Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}