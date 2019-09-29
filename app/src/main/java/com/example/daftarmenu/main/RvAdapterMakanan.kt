package com.example.daftarmenu.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.daftarmenu.R
import com.example.daftarmenu.data.MenuModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.menu_item.*
class RvAdapterMakanan(private val data: List<MenuModel>) :
    RecyclerView.Adapter<RvAdapterMakanan.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.menu_item, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MenuViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bindData(item: MenuModel) {
            tv_mie.text = item.namaMenu
            tv_harga.text = item.hargaMenu
//            image.setImageResource(item.gambarMenu)

            itemView.setOnClickListener{
                Toast.makeText(containerView.context,item.namaMenu,Toast.LENGTH_SHORT).show()
            }
        }

    }

}