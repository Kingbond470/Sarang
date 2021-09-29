package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.fragment.app.FragmentTransaction
import android.R
import androidx.fragment.app.FragmentManager


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.sarang.R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivNotification.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(com.example.sarang.R.id.framelayout_container, NotificationFragment(), "Home Fragment")
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context,"Notification",Toast.LENGTH_SHORT).show()
        }


        ivRecentlyPlayed.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(com.example.sarang.R.id.framelayout_container, RecentlyPlayedFragment(), "Recently Fragment")
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context,"Recently PLayed",Toast.LENGTH_SHORT).show()
        }

        ivSettings.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(com.example.sarang.R.id.framelayout_container, SettingsFragment(), "=Settings Fragment")
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context,"Settings",Toast.LENGTH_SHORT).show()
        }

    }

}