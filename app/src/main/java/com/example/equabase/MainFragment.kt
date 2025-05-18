package com.example.equabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equabase.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val loginVM: LoginVM by viewModels()
    private val mainVM : MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: ButtonAdapter

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

        adapter = ButtonAdapter {category -> val action = MainFragmentDirections.actionMainFragmentToSubTheme(category)
            findNavController().navigate(action)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        mainVM.categories.observe(viewLifecycleOwner) { list -> adapter.submitList(list)}
        }
    }