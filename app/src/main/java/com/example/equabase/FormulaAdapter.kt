package com.example.equabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.equabase.data.PhysicsFormula
import com.example.equabase.databinding.ItemFormulaBinding
import com.zanvent.mathview.MathView


class FormulaAdapter :
    ListAdapter<PhysicsFormula, FormulaAdapter.FormulaViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormulaViewHolder {
        val binding = ItemFormulaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FormulaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FormulaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class FormulaViewHolder(private val binding: ItemFormulaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(formula: PhysicsFormula) {
            binding.formulaTitle.text = formula.name
            binding.formulaDescription.text = formula.description

            val mathView = binding.root.findViewById<MathView>(R.id.mathview)
            mathView.setText("$$${formula.formula}$$")
            mathView.setPixelScaleType(MathView.Scale.SCALE_DP)
            mathView.setTextSize(32)
            mathView.setTextColor("#111111")
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PhysicsFormula>() {
        override fun areItemsTheSame(oldItem: PhysicsFormula, newItem: PhysicsFormula): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: PhysicsFormula, newItem: PhysicsFormula): Boolean {
            return oldItem == newItem
        }
    }
}