package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sarang.R

import com.example.sarang.view.model.PremiumImageSliderModel
import com.example.sarang.view.viewholder.PremiumImageSliderViewHolder
import com.smarteist.autoimageslider.SliderViewAdapter

class PremiumImageSliderAdapter(private val imageList: List<PremiumImageSliderModel>) :
    SliderViewAdapter<PremiumImageSliderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?): PremiumImageSliderViewHolder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.premium_image_slider_layout, parent, false)
        return PremiumImageSliderViewHolder(view)
    }

    override fun onBindViewHolder(holder: PremiumImageSliderViewHolder?, position: Int) {
        val image = imageList[position]
        holder?.setSliderData(image)
    }

    override fun getCount(): Int {
        return imageList.size
    }

}