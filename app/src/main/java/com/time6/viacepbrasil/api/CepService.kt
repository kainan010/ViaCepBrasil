package com.time6.viacepbrasil.api

import com.time6.viacepbrasil.model.DataCepResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET("{CEP}/json/")
    fun getAddressByCEP(@Path("CEP") CEP: String) : Call<DataCepResponse>
}