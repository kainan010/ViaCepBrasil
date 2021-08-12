package com.time6.viacepbrasil.features.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.time6.viacepbrasil.databinding.CepItemBinding
import com.time6.viacepbrasil.model.DataCepRecycle


class CepItemAdapter (val listaCep :List<DataCepRecycle>):RecyclerView.Adapter<CepItemAdapter.ViewHolder>(){

    class ViewHolder(val binding: CepItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind (dataCepRecycle: DataCepRecycle){
            binding.tvCepItemField.text = dataCepRecycle.info
            binding.tvCepItemResponse.text = dataCepRecycle.response
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        CepItemBinding.inflate(LayoutInflater.from(parent.context),parent,false).let {
            return ViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(listaCep[position])
    }

    override fun getItemCount() : Int = listaCep.size
}

