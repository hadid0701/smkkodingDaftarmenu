package com.example.daftarmenu.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daftarmenu.Adapter.RvAdapterMakanan
import com.example.daftarmenu.R
import com.example.daftarmenu.data.MenuDB
import com.example.daftarmenu.data.MenulMakananModel
import kotlinx.android.synthetic.main.menu_makan.*

class MakananFragment : Fragment() {
    companion object {
        fun getInstance(): MakananFragment {
            return MakananFragment()
        }
    }

    val dataMakanan = mutableListOf<MenulMakananModel>()
    //    val rvAdapter = RvAdapterMakanan(dataMakanan)
    var mRvAdapterMakanan= RvAdapterMakanan(dataMakanan)
    var db: MenuDB? = null

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
        rv_makanan.adapter = mRvAdapterMakanan
        rv_makanan.layoutManager = LinearLayoutManager(context)
        db = MenuDB.getInstance(context!!)
        getMenuMakanan()


    }

    private fun getMenuMakanan() {
        db?.menuDao()?.ambilMenuMakanan()?.
                observe(this, Observer { hasil->
                    when(hasil.size==0){
                        true->{
                            Toast.makeText(context,"Data Makanan Masih kosong",
                                Toast.LENGTH_SHORT).show()
                        }
                        false->{
                            dataMakanan.clear()
                            dataMakanan.addAll(hasil)
                            mRvAdapterMakanan.notifyDataSetChanged()
                        }
                    }
                })

    }

}