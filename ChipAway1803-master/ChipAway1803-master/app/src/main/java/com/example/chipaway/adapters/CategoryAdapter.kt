package com.example.chipaway.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chipaway.R
import com.example.chipaway.models.Category
import kotlinx.android.synthetic.main.category.view.*

class CategoryAdapter(private val categories: List<Category>, private val onClickListener: (View, Category) -> Unit) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])

        holder.itemView.setOnClickListener{ view ->
            onClickListener.invoke(view, categories[position])
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(category: Category) {
            Glide.with(itemView).load(category.imagePath).into(itemView.ivCategoryImage)
            itemView.tvCategoryText.text = category.categoryName

            itemView.setOnClickListener{
                Toast.makeText(itemView.context, "clicked category " + category.categoryName, Toast.LENGTH_SHORT).show()
            }

        }
    }
}