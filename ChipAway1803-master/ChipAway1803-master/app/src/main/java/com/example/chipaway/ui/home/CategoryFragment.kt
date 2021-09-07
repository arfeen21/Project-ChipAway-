package com.example.chipaway.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chipaway.ProductAdapters
import com.example.chipaway.Products
import com.example.chipaway.R
import com.example.chipaway.adapters.CategoryAdapter
import com.example.chipaway.adapters.ProductAdapter
import com.example.chipaway.models.Category
import com.example.chipaway.models.Product
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.category_page.*
import kotlinx.android.synthetic.main.category_page.view.*

class CategoryFragment : Fragment() {
    private var products : List<Product> = arrayListOf()
    private var productAdapter : ProductAdapter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.category_page, container, false)

        val categoryId = arguments!!.getInt("Category_id") // id of chosen category
        val categoryName = Category.CATEGORIE_NAMES[categoryId - 1]

        root.txt_categoryTitle.text = categoryName

        val rvProducts: RecyclerView = root.findViewById(R.id.recycler_view_item)

        rvProducts.layoutManager = GridLayoutManager(this.context, 2, LinearLayoutManager.VERTICAL, false)
        rvProducts.adapter = productAdapter
        rvProducts.setHasFixedSize(true)
        products = setProducts().filter { product: Product -> product.categoryId == categoryId }

        if(products.isEmpty()){
            root.txt_categoryTitle.text = "no products found"
        }

        productAdapter = ProductAdapter(products, onClickListener = this::clickPopularProduct)
        rvProducts.adapter = productAdapter

        productAdapter!!.notifyDataSetChanged()

        return root
    }

    /**
     * When you click on a popular product
     */
    private fun clickPopularProduct(view: View, product: Product) {
        Snackbar.make(view, "Clicked on popular product ${product.productName}", Snackbar.LENGTH_SHORT).show()
    }

    private fun setProducts(): ArrayList<Product> {

        var arrayList: ArrayList<Product> = ArrayList()

        arrayList.add(Product("Iphone 10", "https://mobileunlimited.nl/files/16022/webshopartikelen/2016342/apple-iphone-x.jpg", 1))
        arrayList.add(Product("Samsung s20", "https://mobiel-assets.imgix.net/product_images/images/29479/original/s20_gray_front_s_ef7f4059be39f6d5685d56b7518f8219deb97a19.jpeg?auto=compress%2Cformat&w=500&h=500&s=9b16c200bc91153f13140f5eec1281f5",1))
        arrayList.add(Product("Iphone 11", "https://mobileunlimited.nl/files/16022/webshopartikelen/2016342/apple-iphone-x.jpg", 1))

        arrayList.add(Product("Bose QuietComfort 35", "https://s.s-bol.com/imgbase0/imagebase3/large/FC/5/1/3/9/9200000081129315.jpg",2))

        arrayList.add(Product("Lenovo harddrive 450 GB", "https://www02.cp-static.com/objects/multimedia/3/353/1349867887_1871215739_medium_interne-harde-schijven-lenovo-harddrive-450-gb-46u3015.jpg",3))

        return arrayList
    }
}
