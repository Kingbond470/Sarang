package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sarang.R
import com.example.sarang.view.adapter.ToGetYouStartedAdapter
import com.example.sarang.view.model.ToGetYouStarted


class HomeFragment : Fragment() {

    private val togetyoustartedList = ArrayList<ToGetYouStarted>()

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
            ft.replace(
                com.example.sarang.R.id.framelayout_container,
                NotificationFragment(),
                "Home Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show()
        }


        ivRecentlyPlayed.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                com.example.sarang.R.id.framelayout_container,
                RecentlyPlayedFragment(),
                "Recently Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context, "Recently PLayed", Toast.LENGTH_SHORT).show()
        }

        ivSettings.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                com.example.sarang.R.id.framelayout_container,
                SettingsFragment(),
                "=Settings Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
        }

        for(i in 0..10){
            togetyoustartedList.add(ToGetYouStarted(R.drawable.play_date,"Songs"))
        }

        //for to get you started
        val toGetYouStartedAdapter = ToGetYouStartedAdapter(togetyoustartedList)
        val gridLayoutManagerHospitals =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewToGetYouStarted.adapter = toGetYouStartedAdapter
        recyclerViewToGetYouStarted.layoutManager = gridLayoutManagerHospitals
        recyclerViewToGetYouStarted.hasFixedSize()



    }

}