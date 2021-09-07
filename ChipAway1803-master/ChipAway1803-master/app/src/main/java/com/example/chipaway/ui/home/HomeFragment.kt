package com.example.chipaway.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chipaway.R
import com.example.chipaway.adapters.CategoryAdapter
import com.example.chipaway.adapters.ProductAdapter
import com.example.chipaway.models.Category
import com.example.chipaway.models.Product
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    // Categories adapter
    private val categories = arrayListOf<Category>()
    private val categoryAdapter = CategoryAdapter(categories, onClickListener = this::clickCategory)

    // Popular products adapter
    private val popularProducts = arrayListOf<Product>()
    private val popularProdcutsAdapter = ProductAdapter(popularProducts, onClickListener = this::clickPopularProduct)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val rvCategories: RecyclerView = root.findViewById(R.id.rvCategories)
        val rvPopularProducts: RecyclerView = root.findViewById(R.id.rvPopularProducts)

        // Attach the adapters to the recyclerviews
        rvCategories.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoryAdapter

        rvPopularProducts.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvPopularProducts.adapter = popularProdcutsAdapter

        // get every category with matching images and give id
        for(i in Category.CATEGORIE_NAMES.indices) {
            categories.add(Category(i + 1, Category.CATEGORIE_NAMES[i], Category.CATEGORIE_IMAGES[i]))
        }

        // Temporary image
        for(i in 1 .. 20) {
            popularProducts.add(Product("Name $i", "https://images.wehkamp.nl/i/wehkamp/16170156_pb_01/beko-gn162320pt-amerikaanse-koelkast-rvs-8690842154140.jpg?w=2048", 1))
        }

        categoryAdapter.notifyDataSetChanged()
        popularProdcutsAdapter.notifyDataSetChanged()

        return root
    }

    /**
     * When you click on a category
     */
    private fun clickCategory(view: View, category: Category) {
        categories.removeAll(categories)

        val transaction = fragmentManager!!.beginTransaction()
        val categoryFragment = CategoryFragment()

        val bundle = Bundle()
        bundle.putInt("Category_id", category.categoryId)
        categoryFragment.arguments = bundle

        transaction.replace(R.id.nav_host_fragment, categoryFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    /**
     * When you click on a popular product
     */
    private fun clickPopularProduct(view: View, product: Product) {
        Snackbar.make(view, "Clicked on popular product ${product.productName}", Snackbar.LENGTH_SHORT).show()
    }
}
