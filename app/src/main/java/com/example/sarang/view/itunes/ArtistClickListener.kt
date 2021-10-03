package com.example.sarang.view.itunes

import com.example.sarang.view.model.*


interface ArtistClickListener {
    fun onArtistClick(position: Int, artists: PopularArtists)
}

interface ToGetYouStartedClickListener {
    fun onMoodClick(position: Int, mood: ToGetYouStarted)
}

interface ThrowbackClickListener {
    fun onThrowClick(position: Int, throwback: ThrowBack)
}

interface IndiaBestClickListener {
    fun onIndiaBest(position: Int, indiaBest: IndiaBest)
}

interface ChartClickListener {
    fun onChartClick(position: Int, chart: Chart)
}

interface UniquelyClickListener{
    fun onUniquelyClick(position: Int,uniquely: Uniquely)
}

interface ToGetYouStartedFirstClickListener{
    fun onToGetYouStartedOnClick(position: Int, toGetYouStartedFirst: ToGetYouStartedFirst)
}

interface WorkoutClickListener{
    fun onWorkoutClick(position: Int, workout: Workout)
}

interface ArijitClickListener{
    fun onArijitClick(position: Int, arijit: Arijit)
}

interface RecommendedClickListener{
    fun onRecommendedClick(position: Int, recommended: Recommended)
}