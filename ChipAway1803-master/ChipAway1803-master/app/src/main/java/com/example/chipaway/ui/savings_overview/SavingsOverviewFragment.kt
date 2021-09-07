package com.example.chipaway.ui.savings_overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.chipaway.R

class SavingsOverviewFragment : Fragment() {

    private lateinit var savingsOverviewViewModel: SavingsOverviewViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        savingsOverviewViewModel =
                ViewModelProviders.of(this).get(SavingsOverviewViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)




        return root
    }
}
