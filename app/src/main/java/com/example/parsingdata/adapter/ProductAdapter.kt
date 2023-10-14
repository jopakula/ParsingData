package com.example.parsingdata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.parsingdata.R
import com.example.parsingdata.databinding.ListItemBinding
import com.example.parsingdata.retrofit.Product


class ProductAdapter : ListAdapter<Product, ProductAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ListItemBinding.bind(view)

        fun bind(product: Product) = with(binding){
            textViewIndex.text = product.index.toString()
            textViewMac.text = product.Mac.toString()
            textViewTemp.text = product.Temp.toString()
            textViewTimestamp.text = product.Timestamp.toString()
        }
    }

    class Comparator : DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.index == newItem.index
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

}