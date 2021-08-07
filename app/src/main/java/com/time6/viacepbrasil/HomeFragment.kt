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
import com.time6.viacepbrasil.model.DataCepResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var call: Call<DataCepResponse>

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

        binding?.run {
            btHomeFragmentButton.setOnClickListener {
                call = RetrofitBuilder().service().getAdressByCEP(ilHomeFragmentCep.editText?.text.toString())
                call.enqueue(object : Callback<DataCepResponse> {
                    override fun onResponse(
                        call: Call<DataCepResponse>,
                        response: Response<DataCepResponse>
                    ) {
                        response.body().let { body ->
                            val listCep = mutableListOf(
                                DataCepRecycle("CEP:", body?.cep),
                                DataCepRecycle("Logradouro:", body?.logradouro),
                                DataCepRecycle("Complemento:", body?.complemento),
                                DataCepRecycle("Bairro:", body?.bairro),
                                DataCepRecycle("Localidade:", body?.localidade),
                                DataCepRecycle("UF:", body?.uf),
                                DataCepRecycle("IBGE:", body?.ibge),
                                DataCepRecycle("DDD:", body?.ddd)
                            )

                            val adapter = CepItemAdapter(listCep)
                            rvHomeFragmentDatalist.layoutManager = LinearLayoutManager(requireContext())
                            rvHomeFragmentDatalist.adapter = adapter
                        }
                    }

                    override fun onFailure(call: Call<DataCepResponse>, t: Throwable) {}
                })
            }
        }
    }
}