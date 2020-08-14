package com.example.postmanexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postmanexample.api.ApiClient
import com.example.postmanexample.model.City
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiCall()
    }

    fun apiCall(){
        var apiClient = ApiClient()
        var call = apiClient.addCity("Monywa")
        call.enqueue(object: Callback<City> {
            override fun onFailure(call: Call<City>, t: Throwable) {
                txtResponse.text = t.toString()
            }

            override fun onResponse(call: Call<City>, response: Response<City>) {
                txtResponse.text = response.body()?.city.toString()
            }

        })
    }
}