package com.example.sarang.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.view.model.LibraryModel
import kotlinx.android.synthetic.main.library_linear_layout.view.*

class LibraryVH(private val view: View) : RecyclerView.ViewHolder(view) {
    fun setLibraryData(model: LibraryModel) {
        view.apply {
            singer_name.text = model.singerName
            Glide.with(singer_img).load(model.singerImage).into(singer_img)
        }
    }
}