package com.example.sarang.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sarang.R
import com.example.sarang.view.fragment.HomeFragment
import com.example.sarang.view.fragment.LibraryFragment
import com.example.sarang.view.fragment.PremiumFragment
import com.example.sarang.view.fragment.SearchFragment
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

        //Added to favorites
        ivFavoriteWhite.setOnClickListener {
            ivFavoriteWhite.visibility = View.GONE
            ivFavoriteGreen.visibility = View.VISIBLE

            cdAddedToLikedSongs.visibility = View.VISIBLE
            tvAddedToLikedSongs.text = "Added To Liked Songs."

            Handler().postDelayed({
                this@MainActivity
                cdAddedToLikedSongs.visibility = View.GONE
            }, 2000)

        }

        //removed from favorites
        ivFavoriteGreen.setOnClickListener {
            ivFavoriteGreen.visibility = View.GONE
            ivFavoriteWhite.visibility = View.VISIBLE

            cdAddedToLikedSongs.visibility = View.VISIBLE
            tvAddedToLikedSongs.text = "Removed From Liked Songs."

            Handler().postDelayed({
                this@MainActivity
                cdAddedToLikedSongs.visibility = View.GONE
            }, 2000)

        }


        //play
        ivPlay.setOnClickListener {
            ivPlay.visibility = View.GONE
            ivPause.visibility = View.VISIBLE
        }
        //pause
        ivPause.setOnClickListener {
            ivPause.visibility = View.GONE
            ivPlay.visibility = View.VISIBLE
        }


//        //for bottom margin
//        val layoutParams = (framelayout_container?.layoutParams as? ViewGroup.MarginLayoutParams)
//        if (cdPlayingSong.isVisible) {
//            layoutParams?.setMargins(0, 0, 0, 130)
//            framelayout_container?.layoutParams = layoutParams
//        } else {
//            layoutParams?.setMargins(0, 0, 0, 0)
//            framelayout_container?.layoutParams = layoutParams
//        }


    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout_container, fragment)
            commit()
        }
}