package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sarang.R
import com.example.sarang.view.adapter.SearchedSongsAdapter
import com.example.sarang.view.itunes.*
import kotlinx.android.synthetic.main.fragment_artist.*
import kotlinx.android.synthetic.main.fragment_search_songs.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchSongsFragment : Fragment(), ClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val recyclerview = recyclerViewSearchSongs
//        recyclerview.layoutManager = LinearLayoutManager(context)
//        val data = ArrayList<SearchSongsFragmentData>()
//        for (i in 1..20) {
//            data.add(
//                SearchSongsFragmentData(
//                    R.drawable.search_songs_hindi_songs,
//                    "Hindi Songs",
//                    "Playlist"
//                )
//            )
//        }
//        val adapter = SearchSongsFragmentAdapter(data)
//        recyclerview.adapter = adapter


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


        //back to SearchFragment
        ivSearchQueryBack.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                com.example.sarang.R.id.framelayout_container,
                SearchFragment(),
                "Search Songs Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()
        }

    }

    override fun onClick(position: Int, result: Result) {
        //please read what's written in TODO
        TODO("Write the Code to play music")
    }

}

/*
<TextView
    android:id="@+id/tvPlayWhatYouLove"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="480dp"
    android:fontFamily="@font/gotham_bold"
    android:gravity="center_horizontal"
    android:text="@string/play_what_you_love"
    android:textColor="@color/white"
    android:textSize="24sp" />

<TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_below="@id/tvPlayWhatYouLove"
    android:layout_marginTop="14dp"
    android:fontFamily="@font/gotham_light"
    android:gravity="center_horizontal"
    android:text="@string/search_for_artists_songs_podcasts_and_more"
    android:textColor="@color/grey7"
    android:textSize="11sp" />
 */

