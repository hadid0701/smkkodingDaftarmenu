package com.example.daftarmenu.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.daftarmenu.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager_main.adapter=ViewPagerAdapter(supportFragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private val pages = listOf(
            MakananFragment.getInstance(),
            MinumanFragment.getInstance()
        )

        override fun getItem(position: Int): Fragment {
            return pages[position]
        }

        override fun getCount(): Int {
            return pages.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "makanan"
                else -> "minuman"
            }
        }
    }
}