package com.time6.viacepbrasil.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.time6.viacepbrasil.features.home.model.HomeModel
import com.time6.viacepbrasil.model.CepResponseModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val homeModel = HomeModel()

    fun getAddressByCepCoroutines(CEP: String) : CepResponseModel? {
        var cepResponseModel: CepResponseModel? = null

        viewModelScope.launch {
            cepResponseModel = homeModel.getAddressByCepCoroutines(CEP)
        }

        return cepResponseModel
    }

}