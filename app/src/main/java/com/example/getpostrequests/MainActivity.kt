package com.example.getpostrequests


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var edName: EditText
    lateinit var btnSave: Button
    lateinit var tvName: TextView
    lateinit var btnView:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edName = findViewById(R.id.edName)
        btnSave = findViewById(R.id.btnSave)
        tvName =  findViewById(R.id.tvName)
        btnView =findViewById(R.id.btnView)

        btnSave.setOnClickListener(){
            if (edName.text.isNotEmpty()){
                AIcalls.postName(edName.text.toString(), this)
            }else{
                Toast.makeText(applicationContext, "Something Went Wrong", Toast.LENGTH_LONG).show()
        }}

        btnView.setOnClickListener(){
            getAllNames()
        }

    }
    fun getAllNames(){
        val apiInterface=APIclint().getClient()?.create(APIinterfase::class.java)
        apiInterface?.getName()?.enqueue(object : Callback<List<Person.myDataItem>?> {

            override fun onResponse(call: Call<List<Person.myDataItem>?>, response: Response<List<Person.myDataItem>?>) {
                val people = response.body()!!
                for (name in people)
                    "${tvName.text}\n${name.name}\n".also { tvName.text = it }
            }

            override fun onFailure(call: Call<List<Person.myDataItem>?>, t: Throwable) {
                Toast.makeText(applicationContext, "$t",Toast.LENGTH_LONG).show()
            }
        })
    }
}