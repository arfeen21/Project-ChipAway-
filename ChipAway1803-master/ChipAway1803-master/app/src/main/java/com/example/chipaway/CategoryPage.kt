//@author Enes Baran

package com.example.chipaway

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chipaway.ProductAdapters
import com.example.chipaway.Products

class CategoryPage : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var charItem: ArrayList<Products>? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var productAdapters: ProductAdapters? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_page)

        recyclerView = findViewById(R.id.recycler_view_item)
        gridLayoutManager =
            GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)

        charItem = ArrayList()
        charItem = setProducts()
        productAdapters = ProductAdapters(applicationContext, charItem!!)
        recyclerView?.adapter = productAdapters

    }

    private fun setProducts(): ArrayList<Products> {

        var arrayList: ArrayList<Products> = ArrayList()

        arrayList.add(Products(R.drawable.iphone10, "iPhone 10", "500"))
        arrayList.add(Products(R.drawable.iphone7, "iPhone 7","500"))
        arrayList.add(Products(R.drawable.iphonexr, "iPhone XR","500"))
        arrayList.add(Products(R.drawable.iphone8, "iPhone 8","500"))
        arrayList.add(Products(R.drawable.samsungs10, "Samsung S10","500"))
        arrayList.add(Products(R.drawable.samsungs20plus, "Samsung S20 Plus","500"))
        arrayList.add(Products(R.drawable.samsungs10plus, "Samsung S10 Plus","500"))
        arrayList.add(Products(R.drawable.samsungs10lite, "Samsung S10 Lite","500"))
        arrayList.add(Products(R.drawable.samsungs10e, "Samsung S10E","500"))


        return arrayList
    }

}

