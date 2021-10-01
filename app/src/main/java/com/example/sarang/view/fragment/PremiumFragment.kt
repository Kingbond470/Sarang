package com.example.sarang.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.sarang.R
import com.example.sarang.view.adapter.PremiumImageSliderAdapter
import com.example.sarang.view.model.PremiumImageSliderModel
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_premium.*

class PremiumFragment : Fragment(R.layout.fragment_premium) {
    private val imageList = mutableListOf<PremiumImageSliderModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Image Slider
        buildSlider()
        setSliderAdapter()
    }

    private fun buildSlider() {
        imageList.add(PremiumImageSliderModel(R.drawable.premium_img1))
        imageList.add(PremiumImageSliderModel(R.drawable.premium_img2))
        imageList.add(PremiumImageSliderModel(R.drawable.premium_img3))
    }

    private fun setSliderAdapter() {
        val adapter = PremiumImageSliderAdapter(imageList)
        premium_imageSlider.setIndicatorAnimation(IndicatorAnimationType.FILL) //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        premium_imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
        premium_imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        premium_imageSlider.indicatorSelectedColor = Color.WHITE
        premium_imageSlider.indicatorUnselectedColor = Color.GRAY
        premium_imageSlider.scrollTimeInSec = 2 //set scroll delay in seconds :
        premium_imageSlider.startAutoCycle()
        premium_imageSlider.setSliderAdapter(adapter)
    }
}