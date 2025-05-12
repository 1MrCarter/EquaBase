package com.example.equabase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.equabase.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val loginVM: LoginVM by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.d("MainTest", "authState = До теста")
        loginVM.authenticatedState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState){
                LoginVM.AuthenticationState.UNAUTHENTICATED -> {
                    //Log.d("MainTest", "Переходимо на іншу сторінку")
                    findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
                } else -> {
                //Log.d("MainTest", "Ігноруємо бо зайшли")
                }
            } })
        binding.mechanics.setOnClickListener { val action = MainFragmentDirections
            .actionMainFragmentToSubTheme(CategoryType.MECHANICS)
        findNavController().navigate(action) }
        binding.thermodynamics.setOnClickListener { val action = MainFragmentDirections
            .actionMainFragmentToSubTheme(CategoryType.THERMODYNAMICS)
        findNavController().navigate(action) }
        binding.electrodynamics.setOnClickListener { val action = MainFragmentDirections
            .actionMainFragmentToSubTheme(CategoryType.ELECTRODYNAMICS)
            findNavController().navigate(action) }
        binding.fluctuations.setOnClickListener { val action = MainFragmentDirections
            .actionMainFragmentToSubTheme(CategoryType.FLUCUATIONSS)
            findNavController().navigate(action) }
        binding.atom.setOnClickListener { val action = MainFragmentDirections
            .actionMainFragmentToSubTheme(CategoryType.ATOM)
            findNavController().navigate(action) }
        binding.optics.setOnClickListener { val action = MainFragmentDirections
            .actionMainFragmentToSubTheme(CategoryType.OPTICS)
            findNavController().navigate(action) }
        }
    }