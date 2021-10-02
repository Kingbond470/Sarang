package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.itunes.*
import kotlinx.android.synthetic.main.fragment_artist.*
import kotlinx.android.synthetic.main.item_layout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistFragment : Fragment(R.layout.fragment_artist), ClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistName = arguments?.getString("artistName")
        val artistImageId = arguments?.getString("artistImage")

        Glide.with(ivArtistImage).load(artistImageId?.toInt()).into(ivArtistImage)

        val apiService = ITunesNetwork.instance.create(ITunesApiService::class.java)
        val toSearch: String? = artistName
        if (toSearch != null) {
            apiService.getData(toSearch).enqueue(object : Callback<ITunesResponse> {
                override fun onResponse(call: Call<ITunesResponse>, response: Response<ITunesResponse>) {
                    if (response.body() != null) {
                        rcvArtistSongsList.apply {
                            layoutManager = LinearLayoutManager(requireContext())
                            val ar = response.body()!!.results as ArrayList<Result>
                            adapter = MusicAdapter(
                                ar, this@ArtistFragment
                            )
//                            Glide.with(ivArtistImage).load(ar[1].artworkUrl100).into(ivArtistImage)
//                            Glide.with(ivArtistImage).load(artistImageId?.toInt()).into(ivArtistImage)

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
        Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
    }

}