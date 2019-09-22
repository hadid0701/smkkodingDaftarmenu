package com.example.daftarmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class MakananFragment : Fragment() {
    companion object {
        fun getInstance(): MakananFragment {
            return MakananFragment()
        }
    }

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
}