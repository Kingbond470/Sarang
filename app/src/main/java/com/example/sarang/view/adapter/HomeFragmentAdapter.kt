package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.model.ToGetYouStarted
import kotlinx.android.synthetic.main.item_layout_togetyoustarted.view.*

//Adapter for To Get You started
class ToGetYouStartedAdapter(private val listOfHospitals:ArrayList<ToGetYouStarted>): RecyclerView.Adapter<ToGetYouStartedAdapter.ToGetYouStartedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToGetYouStartedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return ToGetYouStartedViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToGetYouStartedViewHolder, position: Int) {
        val hospitals = listOfHospitals[position]
        holder.setData(hospitals)
    }

    override fun getItemCount(): Int {
        return listOfHospitals.size
    }


    //ViewHolder for Hospitals
    class ToGetYouStartedViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        internal fun setData(toGetYouStarted: ToGetYouStarted) {
            view.apply {
                Glide.with(ivGetYouStarted).load(toGetYouStarted.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = toGetYouStarted.title
            }
        }
    }

}