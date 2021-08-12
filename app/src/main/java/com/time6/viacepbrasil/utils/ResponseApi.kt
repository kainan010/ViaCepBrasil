package com.time6.viacepbrasil.utils

sealed class ResponseApi {
    class Success(var data: Any?) : ResponseApi()
    class Error(val messageId: Int) : ResponseApi()
}