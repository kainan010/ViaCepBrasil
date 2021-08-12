package com.time6.viacepbrasil.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CepServiceCoroutines {

    val cep = cepApiClient.create(CepApi::class.java)

    const val URL = "https://viacep.com.br/ws/"

    val cepApiClient: Retrofit get() =
        Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}