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
import com.example.sarang.view.adapter.ArtistAdapter
import com.example.sarang.view.adapter.ToGetYouStartedAdapter
import com.example.sarang.view.itunes.ArtistClickListener
import com.example.sarang.view.model.PopularArtists
import com.example.sarang.view.model.ToGetYouStarted

class HomeFragment : Fragment(), ArtistClickListener {

    private val togetyoustartedList = ArrayList<ToGetYouStarted>()
    private val listOfArtists = ArrayList<PopularArtists>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivNotification.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                NotificationFragment(),
                "Notification Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show()
        }


        ivRecentlyPlayed.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
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

        //Setting RecyclerView Data for ToGetYouStarted
        for (i in 0..10) {
            togetyoustartedList.add(ToGetYouStarted(R.drawable.play_date, "Songs"))
        }

        //for to get you started
        val toGetYouStartedAdapter = ToGetYouStartedAdapter(togetyoustartedList)
        val gridLayoutManagerHospitals =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewToGetYouStarted.adapter = toGetYouStartedAdapter
        recyclerViewToGetYouStarted.layoutManager = gridLayoutManagerHospitals
        recyclerViewToGetYouStarted.hasFixedSize()


        //Setting RecyclerView Data for Artists
        listOfArtists.clear()
        for (i in 1..3) {
            listOfArtists.add(PopularArtists(R.drawable.artist_image_jubin_nautiyal, "Jubin Nautiyal"))
            listOfArtists.add(PopularArtists(R.drawable.artist_image_dua_lipa, "Dua Lipa"))
            listOfArtists.add(PopularArtists(R.drawable.artist_image_arijit_singh, "Arijit Singh"))
        }



        //for artists list rcv
        val artistGridLayoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        val artistAdapter = ArtistAdapter(listOfArtists, this@HomeFragment)
        rcvListOfArtists.adapter = artistAdapter
        rcvListOfArtists.layoutManager = artistGridLayoutManager
        rcvListOfArtists.hasFixedSize()


        button.setOnClickListener {

            val args = Bundle()
            args.putString("artistName", button.text.toString())

            val artistFragment = ArtistFragment()
            artistFragment.arguments = args

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                artistFragment,
                "=Settings Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

            Toast.makeText(context, "Artist Fragment", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onArtistClick(position: Int, artists: PopularArtists) {
        val args = Bundle()
        args.putString("artistName", artists.artistName)
        args.putString("artistImage", artists.artistImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Artist Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()

        Toast.makeText(context, "Artist Fragment", Toast.LENGTH_SHORT).show()
    }

}