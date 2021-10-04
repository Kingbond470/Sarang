package com.example.sarang.view.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sarang.R
import com.example.sarang.data.local.SearchFragmentData
import com.example.sarang.view.activity.SongPlayingActivity
import com.example.sarang.view.adapter.SearchFragmentAdapter
import com.example.sarang.view.adapter.SearchPageAdapter
import com.example.sarang.view.adapter.UniquelyAdapter
import com.example.sarang.view.clicklistenerinterface.SearchPageClickListener
import com.example.sarang.view.model.SearchPageModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(R.layout.fragment_search), SearchPageClickListener {

    private val list = ArrayList<SearchPageModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 1..1) {
            list.add(SearchPageModel(R.drawable.search_at_home, "Home"))
            list.add(SearchPageModel(R.drawable.search_bollywood, "Bollywood"))
            list.add(SearchPageModel(R.drawable.search_charts, "Home"))
            list.add(SearchPageModel(R.drawable.search_concerts, "Home"))
            list.add(SearchPageModel(R.drawable.search_covid19_guide, "Home"))
            list.add(SearchPageModel(R.drawable.search_dance_electronic, "Home"))
            list.add(SearchPageModel(R.drawable.search_decades, "Home"))
            list.add(SearchPageModel(R.drawable.search_devotional, "Home"))
            list.add(SearchPageModel(R.drawable.search_equal, "Home"))
            list.add(SearchPageModel(R.drawable.search_folk_and_acousticjpg, "Home"))
            list.add(SearchPageModel(R.drawable.search_higher_ground, "Home"))
            list.add(SearchPageModel(R.drawable.search_hip_hop, "Home"))
            list.add(SearchPageModel(R.drawable.search_indian_classical, "Home"))
            list.add(SearchPageModel(R.drawable.search_indie, "Home"))
            list.add(SearchPageModel(R.drawable.search_instrumental, "Home"))
            list.add(SearchPageModel(R.drawable.search_k_pop, "Home"))
            list.add(SearchPageModel(R.drawable.search_kids_and_family, "Home"))
            list.add(SearchPageModel(R.drawable.search_made_for_you, "Home"))
            list.add(SearchPageModel(R.drawable.search_marathi, "Home"))
            list.add(SearchPageModel(R.drawable.search_new_releases, "Home"))
            list.add(SearchPageModel(R.drawable.search_only_you, "Home"))
            list.add(SearchPageModel(R.drawable.search_party, "Home"))
            list.add(SearchPageModel(R.drawable.search_podcast, "Home"))
            list.add(SearchPageModel(R.drawable.search_pop, "Home"))
            list.add(SearchPageModel(R.drawable.search_punjabi, "Home"))
            list.add(SearchPageModel(R.drawable.search_r_and_b, "Home"))
            list.add(SearchPageModel(R.drawable.search_radar, "Home"))
            list.add(SearchPageModel(R.drawable.search_romance, "Home"))
            list.add(SearchPageModel(R.drawable.search_sleep, "Home"))
            list.add(SearchPageModel(R.drawable.search_stop_asian_hate, "Home"))
            list.add(SearchPageModel(R.drawable.search_tastemakers, "Home"))
            list.add(SearchPageModel(R.drawable.search_telugu, "Home"))
            list.add(SearchPageModel(R.drawable.search_workout, "Home"))
            list.add(SearchPageModel(R.drawable.search_sleep, "Home"))

        }

        val adapter = SearchPageAdapter(list, this@SearchFragment)
        val grid = GridLayoutManager(context, 2)
        rcvBrowseAll.adapter = adapter
        rcvBrowseAll.layoutManager = grid
        rcvBrowseAll.hasFixedSize()

        // adding data in recyclerview
//        val recyclerview = recyclerViewSearch
//        recyclerview.layoutManager = GridLayoutManager(context, 2)
//        val data = ArrayList<SearchFragmentData>()
//        for (i in 1..2) {
//            data.add(SearchFragmentData(R.drawable.search_podcast))
//            data.add(SearchFragmentData(R.drawable.search_new_releases))
//            data.add(SearchFragmentData(R.drawable.search_charts))
//            data.add(SearchFragmentData(R.drawable.search_concerts))
//            data.add(SearchFragmentData(R.drawable.search_made_for_you))
//            data.add(SearchFragmentData(R.drawable.search_at_home))
//            data.add(SearchFragmentData(R.drawable.search_love_songs))
//            data.add(SearchFragmentData(R.drawable.search_covid_19_guide))
//            data.add(SearchFragmentData(R.drawable.search_only_you))
//        }
//        val adapter = SearchFragmentAdapter(data)
//        recyclerview.adapter = adapter


        // to open a new search fragment
        cardViewSearchBar.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                com.example.sarang.R.id.framelayout_container,
                SearchSongsFragment(),
                "Search Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()
        }


        // play music using search
        tvSearch.setOnClickListener {
            val i = Intent(activity, SongPlayingActivity::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)
        }

    }

    override fun onSearchPageClick(position: Int, searchPageModel: SearchPageModel) {
        val i = Intent(activity, SongPlayingActivity::class.java)
        startActivity(i)
        (activity as Activity?)!!.overridePendingTransition(0, 0)
    }

}