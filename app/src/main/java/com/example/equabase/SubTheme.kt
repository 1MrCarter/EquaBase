package com.example.equabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.equabase.databinding.FragmentSubThemeBinding

class SubTheme : Fragment() {
    private lateinit var binding: FragmentSubThemeBinding
    private lateinit var selectedCategoryType: CategoryType

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sub_theme, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedCategoryType = arguments?.let { SubThemeArgs.fromBundle(it).category } ?: CategoryType.MECHANICS // за замовчуванням
        renderSelectedCategory(selectedCategoryType)
    }
    private fun renderSelectedCategory(categoryType: CategoryType){
        when (categoryType){
            CategoryType.MECHANICS -> {
                binding.mechanicsLayout.visibility = View.VISIBLE
                binding.thermodynamicsLayout.visibility = View.GONE
                binding.electrodynamicsLayout.visibility = View.GONE
                binding.fluctuationsLayout.visibility = View.GONE
                binding.opticsLayout.visibility = View.GONE
                binding.atomLayout.visibility = View.GONE
            }
            CategoryType.THERMODYNAMICS -> {
                binding.mechanicsLayout.visibility = View.GONE
                binding.thermodynamicsLayout.visibility = View.VISIBLE
                binding.electrodynamicsLayout.visibility = View.GONE
                binding.fluctuationsLayout.visibility = View.GONE
                binding.opticsLayout.visibility = View.GONE
                binding.atomLayout.visibility = View.GONE
            }
            CategoryType.ELECTRODYNAMICS -> {
                binding.mechanicsLayout.visibility = View.GONE
                binding.thermodynamicsLayout.visibility = View.GONE
                binding.electrodynamicsLayout.visibility = View.VISIBLE
                binding.fluctuationsLayout.visibility = View.GONE
                binding.opticsLayout.visibility = View.GONE
                binding.atomLayout.visibility = View.GONE
            }
            CategoryType.FLUCUATIONSS -> {
                binding.mechanicsLayout.visibility = View.GONE
                binding.thermodynamicsLayout.visibility = View.GONE
                binding.electrodynamicsLayout.visibility = View.GONE
                binding.fluctuationsLayout.visibility = View.VISIBLE
                binding.opticsLayout.visibility = View.GONE
                binding.atomLayout.visibility = View.GONE
            }
            CategoryType.OPTICS -> {
                binding.mechanicsLayout.visibility = View.GONE
                binding.thermodynamicsLayout.visibility = View.GONE
                binding.electrodynamicsLayout.visibility = View.GONE
                binding.fluctuationsLayout.visibility = View.GONE
                binding.opticsLayout.visibility = View.VISIBLE
                binding.atomLayout.visibility = View.GONE
            }
            CategoryType.ATOM -> {
                binding.mechanicsLayout.visibility = View.GONE
                binding.thermodynamicsLayout.visibility = View.GONE
                binding.electrodynamicsLayout.visibility = View.GONE
                binding.fluctuationsLayout.visibility = View.GONE
                binding.opticsLayout.visibility = View.GONE
                binding.atomLayout.visibility = View.VISIBLE
            }
        }
    }
}