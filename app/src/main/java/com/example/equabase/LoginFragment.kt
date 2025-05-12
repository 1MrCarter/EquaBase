package com.example.equabase

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.equabase.databinding.FragmentLoginBinding
import com.example.equabase.databinding.FragmentMainBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val signInLauncher = registerForActivityResult( //це було трохи поцуплено з їхньої бази
        ActivityResultContracts.StartActivityForResult()
    ){  result ->
        if (result.resultCode == Activity.RESULT_OK)
        {
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null){
                Toast.makeText(requireContext(), "Ви усіпшно увійшли: ${user.displayName}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        } else {
            Toast.makeText(requireContext(), "Вхід не було виконано", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener{
            startSignInProcces()
        }
    }
    private fun startSignInProcces(){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )
        val signInInternet = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInInternet)
    }
}