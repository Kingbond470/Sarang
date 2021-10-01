package com.example.sarang.view.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sarang.R
import com.example.sarang.data.local.SearchFragmentData
import com.example.sarang.view.activity.MainActivity
import com.example.sarang.view.adapter.SearchFragmentAdapter
import kotlinx.android.synthetic.main.fragment_select_music.*
import android.app.Activity

class SelectMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = recyclerViewSelectMusic
        recyclerview.layoutManager = GridLayoutManager(context, 2)
        val data = ArrayList<SearchFragmentData>()
        data.add(SearchFragmentData(R.drawable.select_music_hindi))
        data.add(SearchFragmentData(R.drawable.select_music_english))
        data.add(SearchFragmentData(R.drawable.select_music_punjabi))
        data.add(SearchFragmentData(R.drawable.select_music_tamil))
        data.add(SearchFragmentData(R.drawable.select_music_telugu))
        data.add(SearchFragmentData(R.drawable.select_music_malayalam))
        data.add(SearchFragmentData(R.drawable.select_music_gujarati))
        data.add(SearchFragmentData(R.drawable.select_music_bengali))
        data.add(SearchFragmentData(R.drawable.select_music_kannada))
        val adapter = SearchFragmentAdapter(data)
        recyclerview.adapter = adapter

        tvWhatMusicDoYouLike.setOnClickListener {
            val i = Intent(activity, MainActivity::class.java)
            startActivity(i)
            (activity as Activity?)!!.overridePendingTransition(0, 0)
        }
    }

}