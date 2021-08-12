package com.time6.viacepbrasil.features.home.repository

import com.time6.viacepbrasil.api.CepService
import com.time6.viacepbrasil.base.BaseRepository
import com.time6.viacepbrasil.utils.ResponseApi

class HomeRepository : BaseRepository() {

    suspend fun getAddressByCepCoroutines(CEP: String) : ResponseApi {
     return  safeApiCall {
            CepService.cep.getAddressByCepCoroutines(CEP)
        }
    }

}