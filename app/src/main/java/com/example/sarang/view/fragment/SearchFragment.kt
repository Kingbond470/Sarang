package com.example.sarang.view.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sarang.R
import com.example.sarang.data.local.SearchFragmentData
import com.example.sarang.view.activity.MainActivity
import com.example.sarang.view.activity.SongPlayingActivity
import com.example.sarang.view.adapter.SearchFragmentAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(com.example.sarang.R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = recyclerViewSearch
        recyclerview.layoutManager = GridLayoutManager(context, 2)
        val data = ArrayList<SearchFragmentData>()
        for (i in 1..2) {
            data.add(SearchFragmentData(R.drawable.search_podcast))
            data.add(SearchFragmentData(R.drawable.search_new_releases))
            data.add(SearchFragmentData(R.drawable.search_charts))
            data.add(SearchFragmentData(R.drawable.search_concerts))
            data.add(SearchFragmentData(R.drawable.search_made_for_you))
            data.add(SearchFragmentData(R.drawable.search_at_home))
            data.add(SearchFragmentData(R.drawable.search_love_songs))
            data.add(SearchFragmentData(R.drawable.search_covid_19_guide))
            data.add(SearchFragmentData(R.drawable.search_only_you))
        }
        val adapter = SearchFragmentAdapter(data)
        recyclerview.adapter = adapter


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

        tvSearch.setOnClickListener {
            val i = Intent(activity, SongPlayingActivity::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)
        }

    }

}