package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.clicklistenerinterface.SearchPageClickListener
import com.example.sarang.view.itunes.ClickListener
import com.example.sarang.view.itunes.Result
import com.example.sarang.view.model.SearchPageModel
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.item_layout.view.ivTrackImage
import kotlinx.android.synthetic.main.item_layout_search_song_page.view.*


class SearchPageAdapter(private val responseList: ArrayList<SearchPageModel>, private val clickListener: SearchPageClickListener) :
    RecyclerView.Adapter<SearchPageAdapter.SearchPageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_search_song_page, parent, false)
        return SearchPageViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: SearchPageViewHolder, position: Int) {
        val resultsModel = responseList[position]
        holder.setData(resultsModel)
    }

    override fun getItemCount(): Int {
        return responseList.size
    }

    class SearchPageViewHolder(private val view: View, private val clickListener: SearchPageClickListener) : RecyclerView.ViewHolder(view) {

        fun setData(searchPageModel: SearchPageModel) {
            view.apply {
                Glide.with(ivSearchPageImage).load(searchPageModel.image).into(ivSearchPageImage)
            }
            view.setOnClickListener {
                clickListener.onSearchPageClick(adapterPosition, searchPageModel)
            }
        }
    }

}