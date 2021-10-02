package com.example.sarang.view.itunes

import com.example.sarang.view.model.PopularArtists
import com.example.sarang.view.model.ToGetYouStarted


interface ArtistClickListener {
    fun onArtistClick(position: Int, artists: PopularArtists)
}

interface ToGetYouStartedClickListener {
    fun onMoodClick(position: Int, mood: ToGetYouStarted)
}