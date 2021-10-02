package com.example.sarang.view.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sarang.R
import com.example.sarang.view.activity.SongPlayingActivity
import com.example.sarang.view.adapter.SearchedSongsAdapter
import com.example.sarang.view.itunes.*
import kotlinx.android.synthetic.main.fragment_artist.*
import kotlinx.android.synthetic.main.fragment_search_songs.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchSongsFragment : Fragment(R.layout.fragment_search_songs), ClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //for animation of search edittext
        etSearchQuery.requestFocus()
        ivSearchQueryBack.setOnClickListener {
            flSearchQuery.visibility = View.GONE
            cardViewSearchDummy.visibility = View.VISIBLE
        }

        cardViewSearchDummy.setOnClickListener {
            cardViewSearchDummy.visibility = View.GONE
            flSearchQuery.visibility = View.VISIBLE
            etSearchQuery.requestFocus()
        }

        //search through API
        etSearchQuery.doAfterTextChanged {

            val apiService = ITunesNetwork.instance.create(ITunesApiService::class.java)
            val toSearch: String = etSearchQuery.text.toString()
            apiService.getData(toSearch).enqueue(object : Callback<ITunesResponse> {
                override fun onResponse(
                    call: Call<ITunesResponse>,
                    response: Response<ITunesResponse>
                ) {

                    if (response.body() != null) {
                        rcvSearchSongsThroughAPI.apply {
                            layoutManager = LinearLayoutManager(requireContext())
                            val ar = response.body()!!.results as ArrayList<Result>

                            if (toSearch.trim().isEmpty()) {
                                ar.clear()
                            }
                            adapter = SearchedSongsAdapter(
                                ar, this@SearchSongsFragment
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<ITunesResponse>, t: Throwable) {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun onClick(position: Int, result: Result) {
        val i = Intent(activity, SongPlayingActivity::class.java)
        startActivity(i)
        (activity as Activity?)!!.overridePendingTransition(0, 0)
    }

}