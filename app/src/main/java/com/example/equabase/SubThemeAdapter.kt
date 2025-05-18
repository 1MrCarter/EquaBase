package com.example.equabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class SubThemeAdapter (private val onClick: (SubCategoryType) -> Unit) : ListAdapter<SubCategoryType, SubThemeAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val button: Button = itemView.findViewById(R.id.buttonItem)
        fun bind(item: SubCategoryType) {
            button.text = item.title
            button.setOnClickListener { onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.button_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback: DiffUtil.ItemCallback<SubCategoryType>() {
        override fun areItemsTheSame(oldItem: SubCategoryType, newItem: SubCategoryType) = oldItem == newItem
        override fun areContentsTheSame(oldItem: SubCategoryType, newItem: SubCategoryType) = oldItem == newItem
    }
}