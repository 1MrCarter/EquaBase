package com.example.equabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.equabase.data.PhysicsFormula
import com.example.equabase.data.PhysicsFormulaData
import com.example.equabase.databinding.FragmentAnswerPageBinding

class AnswerPage : Fragment() {
        private lateinit var binding: FragmentAnswerPageBinding
        private lateinit var formulas: List<PhysicsFormula>

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentAnswerPageBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val subcategory = AnswerPageArgs.fromBundle(requireArguments()).subcategory
            formulas = PhysicsFormulaData.formulas.filter { it.subcategory == subcategory }

            binding.formulaWebView.settings.javaScriptEnabled = true

            binding.searchInput.setOnEditorActionListener { _, _, _ ->
                val query = binding.searchInput.text.toString().trim()
                showFormula(query)
                true
            }
        }

        private fun showFormula(query: String) {
            val result = formulas.find {
                it.name.contains(query, ignoreCase = true)
            }

            if (result != null) {
                val template = requireContext().assets.open("formula_template_katex.html")
                    .bufferedReader().use { it.readText() }
                val html = template.replace("FORMULA_PLACEHOLDER", result.formula)

                binding.formulaWebView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null)
                binding.formulaDescription.text = result.description
            } else {
                binding.formulaWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
                binding.formulaDescription.text = "Формулу не знайдено"
            }
        }
}