package com.time6.viacepbrasil.features.home.model

import com.time6.viacepbrasil.features.home.repository.HomeRepository
import com.time6.viacepbrasil.model.CepResponseModel
import com.time6.viacepbrasil.utils.ResponseApi

class HomeModel {

    private val homeRepository = HomeRepository()

    suspend fun getAddressByCepCoroutines(CEP: String) : CepResponseModel? {
        return when (val responseApi = homeRepository.getAddressByCepCoroutines(CEP)) {
            is ResponseApi.Success -> responseApi.data as? CepResponseModel
            is ResponseApi.Error -> responseApi.messageId as? CepResponseModel

        }
    }

}