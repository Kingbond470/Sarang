package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.itunes.ArtistClickListener
import com.example.sarang.view.itunes.ToGetYouStartedClickListener
import com.example.sarang.view.model.PopularArtists
import com.example.sarang.view.model.ToGetYouStarted
import kotlinx.android.synthetic.main.item_layout_for_artists.view.*
import kotlinx.android.synthetic.main.item_layout_togetyoustarted.view.*

//Adapter for To Get You started
class ToGetYouStartedAdapter(
    private val listOfGetStarted: ArrayList<ToGetYouStarted>,
    val clickListener: ToGetYouStartedClickListener
) : RecyclerView.Adapter<ToGetYouStartedAdapter.ToGetYouStartedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToGetYouStartedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return ToGetYouStartedViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ToGetYouStartedViewHolder, position: Int) {
        val hospitals = listOfGetStarted[position]
        holder.setData(hospitals)
    }

    override fun getItemCount(): Int {
        return listOfGetStarted.size
    }

    //ViewHolder for Hospitals
    class ToGetYouStartedViewHolder(
        private val view: View,
        val clickListener: ToGetYouStartedClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(toGetYouStarted: ToGetYouStarted) {
            view.apply {
                Glide.with(ivGetYouStarted).load(toGetYouStarted.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = toGetYouStarted.title
            }
            view.setOnClickListener {
                clickListener.onMoodClick(adapterPosition, toGetYouStarted)
            }
        }
    }

}


//Artist Adapter
class ArtistAdapter(
    private val listOfArtists: ArrayList<PopularArtists>,
    private val clickListener: ArtistClickListener
) : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_for_artists, parent, false)
        return ArtistViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = listOfArtists[position]
        holder.setData(artist)
    }

    override fun getItemCount(): Int {
        return listOfArtists.size
    }


    //ViewHolder for Artists
    class ArtistViewHolder(private val view: View, private val clickListener: ArtistClickListener) :
        RecyclerView.ViewHolder(view) {
        internal fun setData(popularArtists: PopularArtists) {
            view.apply {
                Glide.with(ivArtistImageArtistRcv).load(popularArtists.artistImage)
                    .into(ivArtistImageArtistRcv)
                tvArtistNameArtistRcv.text = popularArtists.artistName
            }
            view.setOnClickListener {
                clickListener.onArtistClick(adapterPosition, popularArtists)
            }
        }
    }

}