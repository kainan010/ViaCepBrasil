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
import com.time6.viacepbrasil.datamodel.DataCepRecycle
import com.time6.viacepbrasil.features.home.view.adapter.CepItemAdapter
import com.time6.viacepbrasil.features.home.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
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

        activity?.let {
            viewModel = ViewModelProvider(it).get(HomeViewModel::class.java)
        }

        binding?.run {
            btHomeFragmentButton.setOnClickListener {
                viewModel.getAddressByCepCoroutines(ilHomeFragmentCep.editText?.text.toString())

                setupObservable()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

    private fun setupObservable() {
        viewModel.onSuccessAddress.observe(viewLifecycleOwner) {
            binding?.run {
                val listCep = mutableListOf(
                    DataCepRecycle("CEP:", it.cep),
                    DataCepRecycle("Logradouro:", it.logradouro),
                    DataCepRecycle("Complemento:", it.complemento),
                    DataCepRecycle("Bairro:", it.bairro),
                    DataCepRecycle("Localidade:", it.localidade),
                    DataCepRecycle("UF:", it.uf),
                    DataCepRecycle("IBGE:", it.ibge),
                    DataCepRecycle("DDD:", it.ddd)
                )

                val adapter = CepItemAdapter(listCep)
                rvHomeFragmentDatalist.layoutManager = LinearLayoutManager(requireContext())
                rvHomeFragmentDatalist.adapter = adapter
            }
        }

        val imm: InputMethodManager =
            activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive()) imm.toggleSoftInput(
            InputMethodManager.HIDE_IMPLICIT_ONLY,
            0
        )
    }

}