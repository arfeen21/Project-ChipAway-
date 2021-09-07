//@author Enes Baran
package com.example.chipaway

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView




class ProductAdapters(var context: Context, var arrayList: ArrayList<Products>) :
    RecyclerView.Adapter<ProductAdapters.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_view_layout_items, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }


    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val productPicture: Products = arrayList.get(position)
        holder.icons.setImageResource(productPicture.icons!!)
        holder.titles.text = productPicture.product
        holder.prices.text = productPicture.prices
        holder.icons.setOnClickListener {

            val intent = Intent(context, MainActivity::class.java) //TODO: change MainActivity to product activity

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
            context.startActivity(intent)
            Toast.makeText(context, productPicture.product, Toast.LENGTH_SHORT).show()
        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var icons = itemView.findViewById<ImageView>(R.id.icon_image_view)
        var titles = itemView.findViewById<TextView>(R.id.title_text_view)
        var prices = itemView.findViewById<TextView>(R.id.price)
    }
}
