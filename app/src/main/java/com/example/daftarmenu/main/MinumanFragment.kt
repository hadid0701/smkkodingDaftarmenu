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

class MinumanFragment : Fragment() {
    companion object {
        fun getInstance(): MinumanFragment {
            return MinumanFragment()
        }
    }

    val dataMinuman = mutableListOf<MenuModel>()
    val rvAdapter = RvAdapter(dataMinuman)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.menu_minuman,
            container, false
        )}

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            rv_makanan.adapter = rvAdapter
            rv_makanan.layoutManager = LinearLayoutManager(context)

            addDummyData()
        }

        private fun addDummyData() {
            dataMinuman.add(
                MenuModel("s jagong", "1B", R.drawable.esjagong)
            )
            dataMinuman.add(
                MenuModel("s botol", "10B", R.drawable.esbotol)
            )
            rvAdapter.notifyDataSetChanged()
        }

}