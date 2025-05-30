package com.example.equabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.equabase.data.PhysicsFormula
import com.example.equabase.data.PhysicsFormulaData
import com.example.equabase.databinding.FragmentAnswerPageBinding

class AnswerPage : Fragment() {
    private lateinit var binding: FragmentAnswerPageBinding
    private val args: AnswerPageArgs by navArgs<AnswerPageArgs>()
    private lateinit var adapter: FormulaAdapter
    private var fullFormulaList = listOf<PhysicsFormula>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnswerPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val subcategory = args.subcategory
        fullFormulaList = PhysicsFormulaData.formulas.filter { it.subcategory == subcategory }

        adapter = FormulaAdapter()
        adapter.submitList(fullFormulaList)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        setupSearch()
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = fullFormulaList.filter {
                    it.name.contains(newText ?: "", ignoreCase = true)
                }
                adapter.submitList(filteredList)
                return true
            }
        })
    }
}