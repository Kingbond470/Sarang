package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.itunes.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_artist.*
import kotlinx.android.synthetic.main.item_layout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtistFragment : Fragment(R.layout.fragment_artist), ClickListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //back to home page
        ivArtistBack.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                HomeFragment(),
                "Artist Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()
        }


        // getting the name of artist and image
        val artistName = arguments?.getString("artistName")
        val artistImageId = arguments?.getString("artistImage")

        //setting the title
        toolBarArtistName.title = artistName

        //setting the image
        Glide.with(ivArtistImage).load(artistImageId?.toInt()).into(ivArtistImage)

        //copulating the recyclerview
        val apiService = ITunesNetwork.instance.create(ITunesApiService::class.java)
        val toSearch: String? = artistName
        if (toSearch != null) {
            apiService.getData(toSearch).enqueue(object : Callback<ITunesResponse> {
                override fun onResponse(
                    call: Call<ITunesResponse>,
                    response: Response<ITunesResponse>
                ) {
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

        //tvCurrentSongName.text = result.artistName

        val bundle = Bundle()
        bundle.putString("previewUrl", result.previewUrl)
        bundle.putString("trackImage", result.artworkUrl100)
        bundle.putString("trackName", result.trackName)
        bundle.putString("collectionName", result.collectionName)
        bundle.putString("trackArtist", result.artistName)


//        val fragment = PlayingSongFragment()
//        fragment.arguments = bundle
//
//        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
//        ft.replace(
//            R.id.containerForPlayingSong,
//            PlayingSongFragment(),
//            "PlayingSongFragment Fragment"
//        )
//        ft.addToBackStack(null)
//        ft.commit()
    }

}