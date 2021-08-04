package com.time6.viacepbrasil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.time6.viacepbrasil.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        binding?.btLogin?.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment2_to_homeFragment)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}