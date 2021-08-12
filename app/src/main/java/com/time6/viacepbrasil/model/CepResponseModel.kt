package com.time6.viacepbrasil.model

data class CepResponseModel(
    val bairro: String,
    val cep: String,
    val ddd: String,
    val ibge: String,
    val localidade: String,
    val logradouro: String,
    val uf: String
){
    var complemento = ""
        get() = if(field == "") "Sem Complemento" else field
}