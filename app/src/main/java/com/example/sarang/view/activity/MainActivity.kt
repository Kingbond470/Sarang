package com.example.sarang.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.sarang.R
import com.example.sarang.view.fragment.HomeFragment
import com.example.sarang.view.fragment.LibraryFragment
import com.example.sarang.view.fragment.PremiumFragment
import com.example.sarang.view.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCurrentFragment(HomeFragment())

        bottomNavBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> setCurrentFragment(HomeFragment())
                R.id.page_2 -> setCurrentFragment(SearchFragment())
                R.id.page_3 -> setCurrentFragment(LibraryFragment())
                R.id.page_4 -> setCurrentFragment(PremiumFragment())

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout_container, fragment)
            commit()
        }
}