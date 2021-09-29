package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sarang.R
import com.example.sarang.view.adapter.ToGetYouStartedAdapter
import com.example.sarang.view.model.ToGetYouStarted
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notification.*
import kotlinx.android.synthetic.main.fragment_recently_played.*


class RecentlyPlayedFragment : Fragment() {

    private val togetyoustartedList = ArrayList<ToGetYouStarted>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recently_played, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivBackRecentlyPlayed.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(com.example.sarang.R.id.framelayout_container, HomeFragment(), "Home Fragment")
            ft.addToBackStack(null)
            ft.commit()
        }


        for(i in 0..10){
            togetyoustartedList.add(ToGetYouStarted(R.drawable.play_date,"Songs"))
        }

        //for to get you started
        val toGetYouStartedAdapter = ToGetYouStartedAdapter(togetyoustartedList)
        val gridLayoutManagerHospitals =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewRecentlyPlayedToday.adapter = toGetYouStartedAdapter
        recyclerViewRecentlyPlayedToday.layoutManager = gridLayoutManagerHospitals
        recyclerViewRecentlyPlayedToday.hasFixedSize()

//        recyclerViewYesterdayRecentlyPlayedToday.adapter = toGetYouStartedAdapter
//        recyclerViewYesterdayRecentlyPlayedToday.layoutManager = gridLayoutManagerHospitals
//        recyclerViewYesterdayRecentlyPlayedToday.hasFixedSize()
//
//        recyclerViewDateRecentlyPlayedToday.adapter = toGetYouStartedAdapter
//        recyclerViewDateRecentlyPlayedToday.layoutManager = gridLayoutManagerHospitals
//        recyclerViewDateRecentlyPlayedToday.hasFixedSize()



    }


}