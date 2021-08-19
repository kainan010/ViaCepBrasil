package com.time6.viacepbrasil.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.time6.viacepbrasil.features.home.model.HomeModel
import com.time6.viacepbrasil.datamodel.CepResponseModel
import com.time6.viacepbrasil.utils.ResponseApi
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val homeModel = HomeModel()

    private val _onSuccessAddress = MutableLiveData<CepResponseModel>()
    val onSuccessAddress: LiveData<CepResponseModel> get() = _onSuccessAddress

    fun getAddressByCepCoroutines(CEP: String ) {
        viewModelScope.launch {
            when (val responseApi = homeModel.getAddressByCepCoroutines(CEP)) {
                is ResponseApi.Success -> {
                    val result = responseApi.data as? CepResponseModel
                    _onSuccessAddress.postValue(result)
                }
            }
        }
    }

}