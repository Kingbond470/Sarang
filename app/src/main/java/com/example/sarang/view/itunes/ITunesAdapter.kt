package com.example.sarang.view.itunes


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.R
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicAdapter(
    private val responseList: ArrayList<Result>,
    private val clickListener: ClickListener
) :
    RecyclerView.Adapter<MusicAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultsModel = responseList[position]
        holder.setData(resultsModel)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    class ViewHolder(private val view: View, private val clickListener: ClickListener) :
        RecyclerView.ViewHolder(view) {

        fun setData(resultsModel: Result) {
            view.apply {
                Glide.with(ivTrackImage).load(resultsModel.artworkUrl100).into(ivTrackImage)
                tvTrackName.text = resultsModel.trackName
                tvArtistName.text = resultsModel.artistName
                //tvCollectionName.text = resultsModel.collectionName
            }
            view.setOnClickListener {
                clickListener.onClick(adapterPosition, resultsModel)
            }
        }
    }

}