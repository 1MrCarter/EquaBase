package com.example.equabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ButtonAdapter( private val onClick: (CategoryType) -> Unit ) : ListAdapter<CategoryType, ButtonAdapter.ButtonViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.button_item, parent, false)
        return ButtonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ButtonViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val button : Button = itemView.findViewById(R.id.buttonItem)

        fun bind (category: CategoryType) {
            button.text = category.title
            button.setOnClickListener { onClick(category) }
        }
    }
    class DiffCallback: DiffUtil.ItemCallback<CategoryType>(){
        override fun areItemsTheSame(oldItem: CategoryType, newItem: CategoryType) = oldItem == newItem
        override fun areContentsTheSame(oldItem: CategoryType, newItem: CategoryType) = oldItem == newItem
    }
}