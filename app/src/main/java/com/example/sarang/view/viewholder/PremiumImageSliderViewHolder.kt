package com.example.sarang.view.viewholder

import android.view.View
import com.example.sarang.view.model.PremiumImageSliderModel
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.premium_image_slider_layout.view.*

class PremiumImageSliderViewHolder(val view: View?) : SliderViewAdapter.ViewHolder(view) {

    fun setSliderData(model: PremiumImageSliderModel) {
        view?.apply {
            premium_img.setImageResource(model.image)
        }
    }
}