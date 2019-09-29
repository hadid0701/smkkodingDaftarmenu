package com.example.daftarmenu.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.daftarmenu.R
import com.example.daftarmenu.data.MenulMakananModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.menu_item.*

class RvAdapterMakanan(private val data: List<MenulMakananModel>) :
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
        fun bindData(item: MenulMakananModel) {
            tv_mie.text = item.namaMenu
            tv_harga.text = item.hargaMenu
            Glide.with(containerView)
                .load(item.gambarMenu)
                .into(image)

            itemView.setOnClickListener{
                Toast.makeText(containerView.context,item.namaMenu,Toast.LENGTH_SHORT).show()
            }
        }

    }

}