package com.example.sarang.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.itunes.*
import com.example.sarang.view.model.*
import kotlinx.android.synthetic.main.item_layout_for_artists.view.*
import kotlinx.android.synthetic.main.item_layout_togetyoustarted.view.*

//Adapter for To Get You started - Mood
class ToGetYouStartedAdapter(
    private val listOfGetStarted: ArrayList<ToGetYouStarted>,
    val clickListener: ToGetYouStartedClickListener
) : RecyclerView.Adapter<ToGetYouStartedAdapter.ToGetYouStartedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToGetYouStartedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return ToGetYouStartedViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ToGetYouStartedViewHolder, position: Int) {
        val hospitals = listOfGetStarted[position]
        holder.setData(hospitals)
    }

    override fun getItemCount(): Int {
        return listOfGetStarted.size
    }

    //ViewHolder for Hospitals
    class ToGetYouStartedViewHolder(
        private val view: View,
        val clickListener: ToGetYouStartedClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(toGetYouStarted: ToGetYouStarted) {
            view.apply {
                Glide.with(ivGetYouStarted).load(toGetYouStarted.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = toGetYouStarted.title
            }
            view.setOnClickListener {
                clickListener.onMoodClick(adapterPosition, toGetYouStarted)
            }
        }
    }

}


//Adapter for To Get You started - First
class ToGetYouStartedFirstAdapter(
    private val listOfGetStartedFirst: ArrayList<ToGetYouStartedFirst>,
    val clickListener: ToGetYouStartedFirstClickListener
) : RecyclerView.Adapter<ToGetYouStartedFirstAdapter.ToGetYouStartedFirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToGetYouStartedFirstViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return ToGetYouStartedFirstViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ToGetYouStartedFirstViewHolder, position: Int) {
        val list = listOfGetStartedFirst[position]
        holder.setData(list)
    }

    override fun getItemCount(): Int {
        return listOfGetStartedFirst.size
    }

    //ViewHolder for Hospitals
    class ToGetYouStartedFirstViewHolder(
        private val view: View,
        val clickListener: ToGetYouStartedFirstClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(toGetYouStarted: ToGetYouStartedFirst) {
            view.apply {
                Glide.with(ivGetYouStarted).load(toGetYouStarted.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = toGetYouStarted.title
            }
            view.setOnClickListener {
                clickListener.onToGetYouStartedOnClick(adapterPosition, toGetYouStarted)
            }
        }
    }

}



//Adapter for Throwback
class ThrowbackAdapter(
    private val listOfThrowBack: ArrayList<ThrowBack>,
    val clickListener: ThrowbackClickListener
) : RecyclerView.Adapter<ThrowbackAdapter.ThrowbackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThrowbackViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return ThrowbackViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ThrowbackViewHolder, position: Int) {
        val throwback = listOfThrowBack[position]
        holder.setData(throwback)
    }

    override fun getItemCount(): Int {
        return listOfThrowBack.size
    }

    //ViewHolder
    class ThrowbackViewHolder(
        private val view: View,
        val clickListener: ThrowbackClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(throwback: ThrowBack) {
            view.apply {
                Glide.with(ivGetYouStarted).load(throwback.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = throwback.title
            }
            view.setOnClickListener {
                clickListener.onThrowClick(adapterPosition, throwback)
            }
        }
    }

}


//Adapter for India best Music
class IndiaBestAdapter(
    private val listOfIndiaBest: ArrayList<IndiaBest>,
    val clickListener: IndiaBestClickListener
) : RecyclerView.Adapter<IndiaBestAdapter.IndiaBestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndiaBestViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return IndiaBestViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: IndiaBestViewHolder, position: Int) {
        val listOfIndia = listOfIndiaBest[position]
        holder.setData(listOfIndia)
    }

    override fun getItemCount(): Int {
        return listOfIndiaBest.size
    }

    //ViewHolder - india best music
    class IndiaBestViewHolder(
        private val view: View,
        val clickListener: IndiaBestClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(indiaBest: IndiaBest) {
            view.apply {
                Glide.with(ivGetYouStarted).load(indiaBest.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = indiaBest.title
            }
            view.setOnClickListener {
                clickListener.onIndiaBest(adapterPosition, indiaBest)
            }
        }
    }

}

//Adapter for India best Music
class ChartAdapter(
    private val listOfChart: ArrayList<Chart>,
    val clickListener: ChartClickListener
) : RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return ChartViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val chartList = listOfChart[position]
        holder.setData(chartList)
    }

    override fun getItemCount(): Int {
        return listOfChart.size
    }

    //ViewHolder - india best music
    class ChartViewHolder(
        private val view: View,
        val clickListener: ChartClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(chart: Chart) {
            view.apply {
                Glide.with(ivGetYouStarted).load(chart.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = chart.title
            }
            view.setOnClickListener {
                clickListener.onChartClick(adapterPosition, chart)
            }
        }
    }
}




//Adapter for Uniquely Music
class UniquelyAdapter(
    private val listOfUniquely: ArrayList<Uniquely>,
    val clickListener: UniquelyClickListener
) : RecyclerView.Adapter<UniquelyAdapter.UniquelyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniquelyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return UniquelyViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: UniquelyViewHolder, position: Int) {
        val chartList = listOfUniquely[position]
        holder.setData(chartList)
    }

    override fun getItemCount(): Int {
        return listOfUniquely.size
    }

    //ViewHolder - Uniquely music
    class UniquelyViewHolder(
        private val view: View,
        val clickListener: UniquelyClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(uniquely: Uniquely) {
            view.apply {
                Glide.with(ivGetYouStarted).load(uniquely.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = uniquely.title
            }
            view.setOnClickListener {
                clickListener.onUniquelyClick(adapterPosition, uniquely)
            }
        }
    }
}



//Artist Adapter
class ArtistAdapter(
    private val listOfArtists: ArrayList<PopularArtists>,
    private val clickListener: ArtistClickListener
) : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_for_artists, parent, false)
        return ArtistViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val artist = listOfArtists[position]
        holder.setData(artist)
    }

    override fun getItemCount(): Int {
        return listOfArtists.size
    }


    //ViewHolder for Artists
    class ArtistViewHolder(private val view: View, private val clickListener: ArtistClickListener) :
        RecyclerView.ViewHolder(view) {
        internal fun setData(popularArtists: PopularArtists) {
            view.apply {
                Glide.with(ivArtistImageArtistRcv).load(popularArtists.artistImage)
                    .into(ivArtistImageArtistRcv)
                tvArtistNameArtistRcv.text = popularArtists.artistName
            }
            view.setOnClickListener {
                clickListener.onArtistClick(adapterPosition, popularArtists)
            }
        }
    }

}




//Adapter for Workout
class WorkoutAdapter(
    private val listOfWorkout: ArrayList<Workout>,
    val clickListener: WorkoutClickListener
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_togetyoustarted, parent, false)
        return WorkoutViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val workoutList = listOfWorkout[position]
        holder.setData(workoutList)
    }

    override fun getItemCount(): Int {
        return listOfWorkout.size
    }

    //ViewHolder - workout
    class WorkoutViewHolder(
        private val view: View,
        val clickListener: WorkoutClickListener
    ) : RecyclerView.ViewHolder(view) {
        internal fun setData(workout: Workout) {
            view.apply {
                Glide.with(ivGetYouStarted).load(workout.albumImage).into(ivGetYouStarted)
                tvTitleGetYouStarted.text = workout.title
            }
            view.setOnClickListener {
                clickListener.onWorkoutClick(adapterPosition, workout)
            }
        }
    }

}