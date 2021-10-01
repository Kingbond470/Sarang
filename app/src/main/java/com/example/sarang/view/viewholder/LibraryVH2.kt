package com.example.sarang.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.view.model.LibraryModel
import kotlinx.android.synthetic.main.library_grid_layout.view.*

class LibraryVH2(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setGridLibraryData(model: LibraryModel) {
        view.apply {
            singer_name2.text = model.singerName
            Glide.with(singer_img2).load(model.singerImage).into(singer_img2)

        }
    }
}