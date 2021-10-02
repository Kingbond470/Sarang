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
import com.example.sarang.view.adapter.ThrowbackAdapter
import com.example.sarang.view.adapter.ToGetYouStartedAdapter
import com.example.sarang.view.itunes.ArtistClickListener
import com.example.sarang.view.itunes.ThrowbackClickListener
import com.example.sarang.view.itunes.ToGetYouStartedClickListener
import com.example.sarang.view.model.PopularArtists
import com.example.sarang.view.model.ThrowBack
import com.example.sarang.view.model.ToGetYouStarted

class HomeFragment : Fragment(R.layout.fragment_home), ArtistClickListener,
    ToGetYouStartedClickListener, ThrowbackClickListener {

    private val togetyoustartedList = ArrayList<ToGetYouStarted>()
    private val throwbackList = ArrayList<ThrowBack>()
    private val listOfArtists = ArrayList<PopularArtists>()


    // view created - all logic/ business
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

//            Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show()
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

//            Toast.makeText(context, "Recently PLayed", Toast.LENGTH_SHORT).show()
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

//            Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
        }

        //Setting RecyclerView Data for ToGetYouStarted
        togetyoustartedList.clear()
        for (i in 1..1) {
            togetyoustartedList.add(ToGetYouStarted(R.drawable.togetyoustarted_youme, "you me"))
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_moodbooster,
                    "Mood Booster"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelingmyself,
                    "feeling myself"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelinggood,
                    "feeling good"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_darkstormy,
                    "dark stormy"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_chilltracks,
                    "chill tracks"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelinggoodpiano,
                    "piano"
                )
            )
        }
        togetyoustartedList.shuffle()

        //for to get you started
        val toGetYouStartedAdapter = ToGetYouStartedAdapter(togetyoustartedList, this@HomeFragment)
        val gridLayoutManagerHospitals =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewToGetYouStarted.adapter = toGetYouStartedAdapter
        recyclerViewToGetYouStarted.layoutManager = gridLayoutManagerHospitals
        recyclerViewToGetYouStarted.hasFixedSize()


        //Setting RecyclerView Data for Throwback
        throwbackList.clear()
        for (i in 1..1) {
            throwbackList.add(ThrowBack(R.drawable.throwback_all_out_hindi, "hindi"))
            throwbackList.add(ThrowBack(R.drawable.throwback_romance, "romance"))
            throwbackList.add(ThrowBack(R.drawable.throwback_hippop, "hollywood"))
            throwbackList.add(ThrowBack(R.drawable.throwback_best_of_decade, "classic song"))
            throwbackList.add(ThrowBack(R.drawable.throwback_rock_classic, "rock classic"))
            throwbackList.add(ThrowBack(R.drawable.throwback_jazz, "jazz"))
            throwbackList.add(ThrowBack(R.drawable.throwback_male_artist, "Male"))
            throwbackList.add(ThrowBack(R.drawable.throwback_swagger, "swagger"))
            throwbackList.add(ThrowBack(R.drawable.throwback_bonnie_tyler, "bonnie tyler"))
            throwbackList.add(ThrowBack(R.drawable.throwback_partyhits, "dance"))
        }
        throwbackList.shuffle()

        //throwback - recycler view
        val throwbackAdapter = ThrowbackAdapter(throwbackList, this@HomeFragment)
        val gridLayoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewThrowback.adapter = throwbackAdapter
        recyclerViewThrowback.layoutManager = gridLayoutManager
        recyclerViewThrowback.hasFixedSize()


        //Setting RecyclerView Data for Artists
        listOfArtists.clear()
        for (i in 1..1) {
            listOfArtists.add(PopularArtists(R.drawable.artist_image_arijit_singh, "Arijit Singh"))
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_justin_bieber,
                    "Justin Bieber"
                )
            )
            listOfArtists.add(PopularArtists(R.drawable.artist_image_dua_lipa, "Dua Lipa"))
            listOfArtists.add(PopularArtists(R.drawable.artist_image_taylor_swift, "Taylor Swift"))
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_jubin_nautiyal,
                    "Jubin Nautiyal"
                )
            )
            listOfArtists.add(PopularArtists(R.drawable.artist_image_blackpink, "BLACKPINK"))
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_aurora_aksnes,
                    "Aurora Aksnes"
                )
            )
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_shreya_ghoshal,
                    "Shreya Ghoshal"
                )
            )
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_pritam_chakraborty,
                    "Pritam Chakraborty"
                )
            )
            listOfArtists.add(PopularArtists(R.drawable.artist_image_bts, "BTS"))
        }
        listOfArtists.shuffle()


        //for artists list rcv
        val artistGridLayoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        val artistAdapter = ArtistAdapter(listOfArtists, this@HomeFragment)
        rcvListOfArtists.adapter = artistAdapter
        rcvListOfArtists.layoutManager = artistGridLayoutManager
        rcvListOfArtists.hasFixedSize()


    }


    // artist click listerner
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
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()

//        Toast.makeText(context, "Artist", Toast.LENGTH_SHORT).show()
    }


    // to get you started - mood click listener
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

//        Toast.makeText(context, "Mood", Toast.LENGTH_SHORT).show()
    }


    // Throwback click listener
    override fun onThrowClick(position: Int, throwback: ThrowBack) {
        val args = Bundle()
        args.putString("artistName", throwback.title)
        args.putString("artistImage", throwback.albumImage.toString())

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