package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sarang.R
import com.example.sarang.data.local.SearchSongsFragmentData
import com.example.sarang.view.adapter.SearchSongsFragmentAdapter
import kotlinx.android.synthetic.main.fragment_search_songs.*

class SearchSongsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = recyclerViewSearchSongs
        recyclerview.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<SearchSongsFragmentData>()
        for (i in 1..20) {
            data.add(
                SearchSongsFragmentData(
                    R.drawable.search_songs_hindi_songs,
                    "Hindi Songs",
                    "Playlist"
                )
            )
        }
        val adapter = SearchSongsFragmentAdapter(data)
        recyclerview.adapter = adapter


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

}