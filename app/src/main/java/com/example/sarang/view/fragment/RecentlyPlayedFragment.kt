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
import com.example.sarang.view.itunes.ToGetYouStartedClickListener
import com.example.sarang.view.model.ToGetYouStarted
import kotlinx.android.synthetic.main.fragment_recently_played.*

class RecentlyPlayedFragment : Fragment(), ToGetYouStartedClickListener{

    private val togetyoustartedList = ArrayList<ToGetYouStarted>()
    private val togetYouStartedYesterday=ArrayList<ToGetYouStarted>()
    private val togetYouStartedDate=ArrayList<ToGetYouStarted>()

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
            ft.replace(R.id.framelayout_container, HomeFragment(), "Home Fragment")
            ft.addToBackStack(null)
            ft.commit()
        }

        //for to get you started
        togetyoustartedList.clear()
        for(i in 0..10){
            togetyoustartedList.add(ToGetYouStarted(R.drawable.togetyoustarted_youme, "You Me"))
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_moodbooster,
                    "Mood Booster"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelingmyself,
                    "Feeling Myself"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelinggood,
                    "Feeling Good"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_darkstormy,
                    "Dark Stormy"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_chilltracks,
                    "Chill Tracks"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelinggoodpiano,
                    "Piano"
                )
            )
        }

        togetyoustartedList.shuffle()

        val toGetYouStartedAdapter = ToGetYouStartedAdapter(togetyoustartedList, this)
        val gridLayoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewRecentlyPlayedToday.adapter = toGetYouStartedAdapter
        recyclerViewRecentlyPlayedToday.layoutManager = gridLayoutManager
        recyclerViewRecentlyPlayedToday.hasFixedSize()

        // for to get you started yesterday
        for(i in 0..10){
            togetYouStartedYesterday.add(ToGetYouStarted(R.drawable.play_date,"Songs"))
        }

//        val toGetYouStartedYesterdayAdapter = ToGetYouStartedAdapter(togetYouStartedYesterday)
//        val gridLayoutManager1 =
//            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
//        recyclerViewYesterday.adapter = toGetYouStartedYesterdayAdapter
//        recyclerViewYesterday.layoutManager = gridLayoutManager1
//        recyclerViewYesterday.hasFixedSize()

        // for to get you started yesterday
        for(i in 0..10){
            togetYouStartedDate.add(ToGetYouStarted(R.drawable.play_date,"Songs"))
        }

//        val toGetYouStartedDate = ToGetYouStartedAdapter(togetYouStartedDate)
//        val gridLayoutManager2 =
//            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
//        recyclerViewDate.adapter = toGetYouStartedDate
//        recyclerViewDate.layoutManager = gridLayoutManager2
//        recyclerViewDate.hasFixedSize()

//
//        recyclerViewYesterdayRecentlyPlayedToday.adapter = toGetYouStartedAdapter
//        recyclerViewYesterdayRecentlyPlayedToday.layoutManager = gridLayoutManagerHospitals
//        recyclerViewYesterdayRecentlyPlayedToday.hasFixedSize()
//
//        recyclerViewDateRecentlyPlayedToday.adapter = toGetYouStartedAdapter
//        recyclerViewDateRecentlyPlayedToday.layoutManager = gridLayoutManagerHospitals
//        recyclerViewDateRecentlyPlayedToday.hasFixedSize()

    }

    override fun onMoodClick(position: Int, mood: ToGetYouStarted) {

        val args = Bundle()
        args.putString("artistName", mood.title)
        args.putString("artistImage", mood.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()

    }

}