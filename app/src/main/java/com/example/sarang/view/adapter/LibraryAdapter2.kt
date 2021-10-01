package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sarang.R
import com.example.sarang.view.model.LibraryModel
import com.example.sarang.view.viewholder.LibraryVH2

class LibraryAdapter2(private val libraryList: List<LibraryModel>) :
    RecyclerView.Adapter<LibraryVH2>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryVH2 {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.library_grid_layout, parent, false)
        return LibraryVH2(view)
    }

    override fun onBindViewHolder(holder: LibraryVH2, position: Int) {
        val model = libraryList[position]
        holder.setGridLibraryData(model)
    }

    override fun getItemCount(): Int {
        return libraryList.size
    }

}