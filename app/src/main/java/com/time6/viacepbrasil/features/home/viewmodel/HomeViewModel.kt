package com.time6.viacepbrasil.features.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.time6.viacepbrasil.base.BaseViewModel
import com.time6.viacepbrasil.datamodel.CepResponseModel
import com.time6.viacepbrasil.features.home.model.HomeModel
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {
    private val homeModel = HomeModel()

    private val _onSuccessAddress = MutableLiveData<CepResponseModel>()
    val onSuccessAddress: LiveData<CepResponseModel> get() = _onSuccessAddress

    fun getAddressByCepCoroutines(CEP: String) {
        viewModelScope.launch {
            this@HomeViewModel.callApi(
                call = { homeModel.getAddressByCepCoroutines(CEP) },
                onSuccess = { _onSuccessAddress.postValue(it as? CepResponseModel) }
            )
        }
    }

}