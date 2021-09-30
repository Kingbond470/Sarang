package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sarang.R
import com.example.sarang.view.model.LibraryModel
import com.example.sarang.view.viewholder.LibraryVH

class LibraryAdapter(private val libraryList: List<LibraryModel>) :
    RecyclerView.Adapter<LibraryVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LibraryVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.library_linear_layout, parent, false)
        return LibraryVH(view)
    }

    override fun onBindViewHolder(holder: LibraryVH, position: Int) {
        val model = libraryList[position]
        holder.setLibraryData(model)
    }

    override fun getItemCount(): Int {
        return libraryList.size
    }
}