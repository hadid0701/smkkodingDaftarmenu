package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.R
import com.example.daftarmenu.data.MenuModel
import kotlinx.android.synthetic.main.menu_makan.*

class MakananFragment : Fragment() {
    companion object {
        fun getInstance(): MakananFragment {
            return MakananFragment()
        }
    }

    val dataMakanan = mutableListOf<MenuModel>()
    val rvAdapter = RvAdapter(dataMakanan)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.menu_makan,
            container, false

        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_makanan.adapter = rvAdapter
        rv_makanan.layoutManager = LinearLayoutManager(context)

        addDummyData()
    }

    private fun addDummyData() {
        dataMakanan.add(
            MenuModel
                ("JANGAN", "10.000", R.drawable.sayur_bayam)
        )
        dataMakanan.add(
            MenuModel("sate", "10K/ bidji", R.drawable.sate)
        )
        rvAdapter.notifyDataSetChanged()
    }
}