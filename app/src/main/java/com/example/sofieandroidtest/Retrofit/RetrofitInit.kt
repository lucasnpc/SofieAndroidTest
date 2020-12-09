package com.example.sofieandroidtest.Retrofit

import com.example.sofieandroidtest.Interface.NetworkInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {
    companion object {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(NetworkInterface.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun getNetworkInterface(): NetworkInterface {
            return retrofit.create(NetworkInterface::class.java)
        }
    }

}