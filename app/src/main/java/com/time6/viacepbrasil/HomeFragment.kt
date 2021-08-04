package com.time6.viacepbrasil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.time6.viacepbrasil.adapter.CepItemAdapter
import com.time6.viacepbrasil.databinding.FragmentHomeBinding
import com.time6.viacepbrasil.model.DataCepRecycle


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listCep = listOf(
            DataCepRecycle("Cep", "01001-000"),
            DataCepRecycle("logradouro", "Praça da Sé"),
            DataCepRecycle("complemento", "lado ímpar"),
            DataCepRecycle("bairro", "Sé"),
            DataCepRecycle("localidade", "São Paulo"),
            DataCepRecycle("uf", "SP"),
            DataCepRecycle("ibge", "3550308"),
            DataCepRecycle("gia", "1004"),
            DataCepRecycle("ddd", "11"),
            DataCepRecycle("siafi", "7107")
        )



        val adapter = CepItemAdapter(listCep)
        binding?.rvHomeFragmentDatalist?.layoutManager = LinearLayoutManager(requireContext())
            binding?.rvHomeFragmentDatalist?.adapter = adapter
    }


}