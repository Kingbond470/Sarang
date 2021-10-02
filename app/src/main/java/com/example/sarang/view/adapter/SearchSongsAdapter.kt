package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.itunes.ClickListener
import com.example.sarang.view.itunes.Result
import kotlinx.android.synthetic.main.item_layout.view.*


class SearchedSongsAdapter(private val responseList: ArrayList<Result>, private val clickListener: ClickListener) :
    RecyclerView.Adapter<SearchedSongsAdapter.SearchedSongsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchedSongsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return SearchedSongsViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: SearchedSongsViewHolder, position: Int) {
        val resultsModel = responseList[position]
        holder.setData(resultsModel)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    class SearchedSongsViewHolder(private val view: View, private val clickListener: ClickListener) : RecyclerView.ViewHolder(view) {

        fun setData(resultsModel: Result) {
            view.apply {
                Glide.with(ivTrackImage).load(resultsModel.artworkUrl100).into(ivTrackImage)
                tvTrackName.text = resultsModel.trackName
                tvArtistName.text = resultsModel.artistName
                tvCollectionName.text = resultsModel.collectionName
            }
            view.setOnClickListener {
                clickListener.onClick(adapterPosition, resultsModel)
            }
        }
    }

}