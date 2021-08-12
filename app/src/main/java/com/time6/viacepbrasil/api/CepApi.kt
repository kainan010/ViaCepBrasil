package com.time6.viacepbrasil.api

import com.time6.viacepbrasil.datamodel.CepResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CepApi {

    @GET("{CEP}/json/")
    suspend fun getAddressByCepCoroutines(@Path("CEP") CEP: String): Response<CepResponseModel>

}