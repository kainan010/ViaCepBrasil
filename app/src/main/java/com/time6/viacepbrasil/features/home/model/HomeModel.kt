package com.time6.viacepbrasil.features.home.model

import com.time6.viacepbrasil.features.home.repository.HomeRepository
import com.time6.viacepbrasil.datamodel.CepResponseModel
import com.time6.viacepbrasil.utils.ResponseApi

class HomeModel {

    private val homeRepository = HomeRepository()

    suspend fun getAddressByCepCoroutines(CEP: String) : ResponseApi {
        return homeRepository.getAddressByCepCoroutines(CEP)
    }

}