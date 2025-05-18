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
    //private lateinit var selectedCategoryType: CategoryType
    private val viewModel: SubTopicViewModel by viewModels()
    private lateinit var adapter: SubThemeAdapter

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
        // Отримуємо передану категорію
        val categoryArg = arguments?.let { SubThemeArgs.fromBundle(it).category }
            ?: CategoryType.MECHANICS

        // Встановлюємо її у ViewModel
        viewModel.setCategory(categoryArg)

        // Налаштовуємо адаптер для списку підтем
        adapter = SubThemeAdapter { subTopic ->
            // Перехід до AnswerPage з передачею обраної підкатегорії
            val action = SubThemeDirections.actionSubThemeToAnswerPage(subTopic)
            findNavController().navigate(action)
        }

        // Прив'язуємо адаптер до RecyclerView
        binding.subThemeRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.subThemeRecycler.adapter = adapter

        // Спостерігаємо за підтемами і оновлюємо список
        viewModel.subTopics.observe(viewLifecycleOwner) { subCategoryList ->
            adapter.submitList(subCategoryList)
        }
    }


}