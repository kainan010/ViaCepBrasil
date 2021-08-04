package com.time6.viacepbrasil

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    private val URL = "https://viacep.com.br/ws/"
    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun service() : CepService = retrofit.create(CepService::class.java)
}