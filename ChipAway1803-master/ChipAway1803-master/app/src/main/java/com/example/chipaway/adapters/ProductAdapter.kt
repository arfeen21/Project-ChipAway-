package com.example.chipaway.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chipaway.R
import com.example.chipaway.models.Product
import kotlinx.android.synthetic.main.product.view.*

class ProductAdapter(private val popularProduct: List<Product>, private val onClickListener: (View, Product) -> Unit): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return popularProduct.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(popularProduct[position])

        holder.itemView.setOnClickListener { view ->
            onClickListener.invoke(view, popularProduct[position])
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(popularProduct: Product) {
            Glide.with(itemView).load(popularProduct.productImage).into(itemView.ivProductImage)
            itemView.tvProductActivator.text = popularProduct.productName
        }
    }
}