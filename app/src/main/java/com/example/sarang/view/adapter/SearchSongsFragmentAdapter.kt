package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sarang.R
import com.example.sarang.data.local.SearchSongsFragmentData

class SearchSongsFragmentAdapter(private val mList: List<SearchSongsFragmentData>) :
    RecyclerView.Adapter<SearchSongsFragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_search_songs_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.textViewTitle.text = ItemsViewModel.title
        holder.textViewDescription.text = ItemsViewModel.description
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivSearchItemImage)
        val textViewTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val textViewDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

}