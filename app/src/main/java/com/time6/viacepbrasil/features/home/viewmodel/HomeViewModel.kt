package com.time6.viacepbrasil.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.time6.viacepbrasil.features.home.model.HomeModel
import com.time6.viacepbrasil.model.CepResponseModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    var cepResponseModel: CepResponseModel? = null
    private val homeModel = HomeModel()

    fun getAddressByCepCoroutines(CEP: String ) : CepResponseModel? {


        viewModelScope.launch {
            cepResponseModel = homeModel.getAddressByCepCoroutines(CEP)
        }

        return cepResponseModel
    }

}