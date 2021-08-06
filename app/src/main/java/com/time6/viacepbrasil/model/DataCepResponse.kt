package com.time6.viacepbrasil.model

data class DataCepResponse(
    val cep: String,
    val logradouro: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ibge: String,
    val gia: String,
    val ddd: String,
    val siafi: String
){
    var complemento = ""
        get() = if(field == "") "Sem Complemento" else field

}