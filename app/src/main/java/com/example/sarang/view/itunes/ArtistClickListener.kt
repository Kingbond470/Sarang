package com.example.sarang.view.itunes

import com.example.sarang.view.model.PopularArtists


interface ArtistClickListener {
    fun onArtistClick(position: Int, artists: PopularArtists)
}