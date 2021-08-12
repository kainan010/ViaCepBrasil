package com.time6.viacepbrasil.features.home.view


import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.time6.viacepbrasil.databinding.FragmentHomeBinding
import com.time6.viacepbrasil.features.home.view.adapter.CepItemAdapter
import com.time6.viacepbrasil.features.home.viewmodel.HomeViewModel
import com.time6.viacepbrasil.model.DataCepRecycle


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
//    private lateinit var call: Call<DataCepResponse>
    private lateinit var viewModel: HomeViewModel

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
//                call = RetrofitBuilder().service().getAdressByCEP(ilHomeFragmentCep.editText?.text.toString())
//                call.enqueue(object : Callback<DataCepResponse> {
//                    override fun onResponse(
//                        call: Call<DataCepResponse>,
//                        response: Response<DataCepResponse>
//                    ) {
//                        response.body().let { body ->
//                            val listCep = mutableListOf(
//                                DataCepRecycle("CEP:", body?.cep),
//                                DataCepRecycle("Logradouro:", body?.logradouro),
//                                DataCepRecycle("Complemento:", body?.complemento),
//                                DataCepRecycle("Bairro:", body?.bairro),
//                                DataCepRecycle("Localidade:", body?.localidade),
//                                DataCepRecycle("UF:", body?.uf),
//                                DataCepRecycle("IBGE:", body?.ibge),
//                                DataCepRecycle("DDD:", body?.ddd)
//                            )
//
//                            val adapter = CepItemAdapter(listCep)
//                            rvHomeFragmentDatalist.layoutManager = LinearLayoutManager(requireContext())
//                            rvHomeFragmentDatalist.adapter = adapter
//                        }
//                        val imm: InputMethodManager =
//                          activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//                        if (imm.isActive()) imm.toggleSoftInput(
//                            InputMethodManager.HIDE_IMPLICIT_ONLY,
//                            0
//                        )
//                    }
//
//                    override fun onFailure(call: Call<DataCepResponse>, t: Throwable) {}
//                })

                activity?.let {
                    viewModel = ViewModelProvider(it).get(HomeViewModel::class.java)

                    viewModel.getAddressByCepCoroutines(ilHomeFragmentCep.editText?.text.toString())?.let { CepResponseModel ->
                        val listCep = mutableListOf(
                            DataCepRecycle("CEP:", CepResponseModel.cep),
                            DataCepRecycle("Logradouro:", CepResponseModel.logradouro),
                            DataCepRecycle("Complemento:", CepResponseModel.complemento),
                            DataCepRecycle("Bairro:", CepResponseModel.bairro),
                            DataCepRecycle("Localidade:", CepResponseModel.localidade),
                            DataCepRecycle("UF:", CepResponseModel.uf),
                            DataCepRecycle("IBGE:", CepResponseModel.ibge),
                            DataCepRecycle("DDD:", CepResponseModel.ddd)
                        )

                        val adapter = CepItemAdapter(listCep)
                        rvHomeFragmentDatalist.layoutManager = LinearLayoutManager(requireContext())
                        rvHomeFragmentDatalist.adapter = adapter
                    }

                    val imm: InputMethodManager =
                        activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    if (imm.isActive()) imm.toggleSoftInput(
                        InputMethodManager.HIDE_IMPLICIT_ONLY,
                        0
                    )
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}