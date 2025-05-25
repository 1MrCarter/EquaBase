package com.example.equabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equabase.databinding.FragmentSubThemeBinding

class SubTheme : Fragment() {
    private lateinit var binding: FragmentSubThemeBinding
    private val viewModel: CategoryItemViewModel by viewModels()
    private lateinit var adapter: CategoryItemAdapter
    //private lateinit var selectedCategoryType: CategoryType
    //private val viewModel: SubTopicViewModel by viewModels()
    //private lateinit var adapter: SubThemeAdapter

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

        val selectedCategory = SubThemeArgs.fromBundle(requireArguments()).category
        viewModel.loadSubCategories(selectedCategory)

        // Налаштовуємо адаптер для списку підтем
        adapter = CategoryItemAdapter { item ->
            if (item is CategoryItem.SubCategory) {
                val action = SubThemeDirections.actionSubThemeToAnswerPage(item.type)
                findNavController().navigate(action)
            }
        }

        binding.subThemeRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SubTheme.adapter
        }
        viewModel.items.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }

    }


}