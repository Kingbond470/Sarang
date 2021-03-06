package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sarang.R
import com.example.sarang.view.adapter.*
import com.example.sarang.view.itunes.*
import com.example.sarang.view.model.*

class HomeFragment : Fragment(R.layout.fragment_home), ArtistClickListener,
    ToGetYouStartedClickListener, ThrowbackClickListener, IndiaBestClickListener,
    ChartClickListener, UniquelyClickListener,
    ToGetYouStartedFirstClickListener, WorkoutClickListener,
    ArijitClickListener, RecommendedClickListener{

    private val togetyoustartedList = ArrayList<ToGetYouStarted>()
    private val throwbackList = ArrayList<ThrowBack>()
    private val indiaBestList = ArrayList<IndiaBest>()
    private val chartList = ArrayList<Chart>()
    private val uniquelyList = ArrayList<Uniquely>()
    private val togetyoustartedFirstList = ArrayList<ToGetYouStartedFirst>()
    private val workoutList=ArrayList<Workout>()
    private val arijitList=ArrayList<Arijit>()
    private val recommendedList=ArrayList<Recommended>()
    private val listOfArtists = ArrayList<PopularArtists>()


    // view created - all logic/ business
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivNotification.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                NotificationFragment(),
                "Notification Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

//            Toast.makeText(context, "Notification", Toast.LENGTH_SHORT).show()
        }


        ivRecentlyPlayed.setOnClickListener {

            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                RecentlyPlayedFragment(),
                "Recently Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

//            Toast.makeText(context, "Recently PLayed", Toast.LENGTH_SHORT).show()
        }

        ivSettings.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                com.example.sarang.R.id.framelayout_container,
                SettingsFragment(),
                "=Settings Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()

//            Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
        }

        //Setting RecyclerView Data for ToGetYouStarted
        togetyoustartedList.clear()
        for (i in 1..1) {
            togetyoustartedList.add(ToGetYouStarted(R.drawable.togetyoustarted_youme, "You Me"))
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_moodbooster,
                    "Mood Booster"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelingmyself,
                    "Feeling Myself"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelinggood,
                    "Feeling Good"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_darkstormy,
                    "Dark Stormy"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_chilltracks,
                    "Chill Tracks"
                )
            )
            togetyoustartedList.add(
                ToGetYouStarted(
                    R.drawable.togetyoustarted_feelinggoodpiano,
                    "Piano"
                )
            )
        }
        togetyoustartedList.shuffle()
        //for to get you started
        val toGetYouStartedAdapter = ToGetYouStartedAdapter(togetyoustartedList, this@HomeFragment)
        val gridLayoutManagerGetStarted =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewToGetYouStarted.adapter = toGetYouStartedAdapter
        recyclerViewToGetYouStarted.layoutManager = gridLayoutManagerGetStarted
        recyclerViewToGetYouStarted.hasFixedSize()


        //Setting RecyclerView Data for Throwback
        throwbackList.clear()
        for (i in 1..1) {
            throwbackList.add(ThrowBack(R.drawable.throwback_all_out_hindi, "Hindi"))
            throwbackList.add(ThrowBack(R.drawable.throwback_romance, "Romance"))
            throwbackList.add(ThrowBack(R.drawable.throwback_hippop, "Hollywood"))
            throwbackList.add(ThrowBack(R.drawable.throwback_best_of_decade, "Classic Song"))
            throwbackList.add(ThrowBack(R.drawable.throwback_rock_classic, "Rock Classic"))
            throwbackList.add(ThrowBack(R.drawable.throwback_jazz, "Jazz"))
            throwbackList.add(ThrowBack(R.drawable.throwback_male_artist, "Male"))
            throwbackList.add(ThrowBack(R.drawable.throwback_swagger, "Swagger"))
            throwbackList.add(ThrowBack(R.drawable.throwback_bonnie_tyler, "Bonnie Tyler"))
            throwbackList.add(ThrowBack(R.drawable.throwback_partyhits, "Dance"))
        }
        throwbackList.shuffle()
        //throwback - recycler view
        val throwbackAdapter = ThrowbackAdapter(throwbackList, this@HomeFragment)
        val gridLayoutManagerThrowBack =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewThrowback.adapter = throwbackAdapter
        recyclerViewThrowback.layoutManager = gridLayoutManagerThrowBack
        recyclerViewThrowback.hasFixedSize()


        //Setting RecyclerView Data for Recommended
        recommendedList.clear()
        for (i in 1..1) {
            recommendedList.add(Recommended(R.drawable.recommended_fitness, "Fitness"))
            recommendedList.add(Recommended(R.drawable.recommended_girl_power, "Girl"))
            recommendedList.add(Recommended(R.drawable.recommended_hits_spring, "Spring"))
            recommendedList.add(Recommended(R.drawable.recommended_non_stop, "Stop"))
            recommendedList.add(Recommended(R.drawable.recommended_workout, "Workout"))

        }
        recommendedList.shuffle()
        //throwback - recycler view
        val recommendedAdapter = RecommendedAdapter(recommendedList, this@HomeFragment)
        val gridLayoutManagerRecommended =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recvRecommendedToday.adapter = recommendedAdapter
        recvRecommendedToday.layoutManager = gridLayoutManagerRecommended
        recvRecommendedToday.hasFixedSize()


        //Setting RecyclerView Data for To Get You Started First
        togetyoustartedFirstList.clear()
        for (i in 1..1) {
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_album,
                    "Today Album"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_bollywood_acoustic,
                    "Bollywood Acoustic"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_bollywood_romance,
                    "Bollywood Romance"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_filmy_cover,
                    "Cover"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_hindi_hits,
                    "Hindi"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_indiestan,
                    "Indie"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_punjabi,
                    "Punjabi"
                )
            )
            togetyoustartedFirstList.add(
                ToGetYouStartedFirst(
                    R.drawable.recommended_today_punjabi_juk_box,
                    "Punjabi"
                )
            )
        }
        togetyoustartedFirstList.shuffle()
        //To Get You Started First - recycler view
        val toGetYouStartedFirstAdapter =
            ToGetYouStartedFirstAdapter(togetyoustartedFirstList, this@HomeFragment)
        val gridLayoutManagerFirst =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewToGetYouStartedFirst.adapter = toGetYouStartedFirstAdapter
        recyclerViewToGetYouStartedFirst.layoutManager = gridLayoutManagerFirst
        recyclerViewToGetYouStartedFirst.hasFixedSize()


        //Setting RecyclerView Data for India Best
        indiaBestList.clear()
        for (i in 1..1) {
            indiaBestList.add(IndiaBest(R.drawable.india_bollywood_butter, "Arijit"))
            indiaBestList.add(IndiaBest(R.drawable.india_kollywood, "Kollywood"))
            indiaBestList.add(IndiaBest(R.drawable.india_punjabi, "Punjabi"))
            indiaBestList.add(IndiaBest(R.drawable.india_tollywood_pearls, "Tollywood"))
            indiaBestList.add(IndiaBest(R.drawable.india_indie_india, "Indie"))
            indiaBestList.add(IndiaBest(R.drawable.india_marathi, "Marathi"))
            indiaBestList.add(IndiaBest(R.drawable.india_malayalam, "Malayalam"))
            indiaBestList.add(IndiaBest(R.drawable.india_radar, "Radar"))
            indiaBestList.add(IndiaBest(R.drawable.india_bhojpuri, "Bhojpuri"))
            indiaBestList.add(IndiaBest(R.drawable.india_kannada, "Kannada"))
        }
        indiaBestList.shuffle()
        //India Best - recycler view
        val indiaBestAdapter = IndiaBestAdapter(indiaBestList, this@HomeFragment)
        val gridLayoutManagerIndiaBest =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewIndiaBest.adapter = indiaBestAdapter
        recyclerViewIndiaBest.layoutManager = gridLayoutManagerIndiaBest
        recyclerViewIndiaBest.hasFixedSize()



        //Setting RecyclerView Data for India Best
        arijitList.clear()
        for (i in 1..1) {
            arijitList.add(Arijit(R.drawable.arijit_grove, "Arijit"))
            arijitList.add(Arijit(R.drawable.arijit_hits, "Arijit"))
            arijitList.add(Arijit(R.drawable.arijit_jiya_jaye, "Arijit"))
            arijitList.add(Arijit(R.drawable.artist_image_jubin_nautiyal, "Arijit"))
            arijitList.add(Arijit(R.drawable.arijit_love, "Arijit"))
            arijitList.add(Arijit(R.drawable.arijit_love_istic, "Arijit"))
        }
        arijitList.shuffle()
        //India Best - recycler view
        val arijitAdapter = ArijitAdapter(arijitList, this@HomeFragment)
        val gridLayoutManagerArijit =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewArijit.adapter = arijitAdapter
        recyclerViewArijit.layoutManager = gridLayoutManagerArijit
        recyclerViewArijit.hasFixedSize()




        //Setting RecyclerView Data for Chart
        chartList.clear()
        for (i in 1..1) {
            chartList.add(Chart(R.drawable.chart_hindi_bollywood, "Hindi"))
            chartList.add(Chart(R.drawable.chart_latest_telgu, "Anurag Kulkarni"))
            chartList.add(Chart(R.drawable.chart_new_music_punjabi, "Punjabi"))
            chartList.add(Chart(R.drawable.chart_tamil, "Tamil"))
            chartList.add(Chart(R.drawable.chart_telgu_hits, "Telugu"))
            chartList.add(Chart(R.drawable.chart_top_hits_punjabi, "Jassi Gill"))
            chartList.add(Chart(R.drawable.chart_topglobal, "Stay"))
            chartList.add(Chart(R.drawable.chart_topindia, "Jubin Nautiyal"))
        }
        chartList.shuffle()
        //Chart - recycler view
        val chartAdapter = ChartAdapter(chartList, this@HomeFragment)
        val gridLayoutManagerChart =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewChart.adapter = chartAdapter
        recyclerViewChart.layoutManager = gridLayoutManagerChart
        recyclerViewChart.hasFixedSize()


        //Setting RecyclerView Data for Uniquely Yours
        uniquelyList.clear()
        for (i in 1..1) {
            uniquelyList.add(Uniquely(R.drawable.uniquely_yours_on_repeat, "Repeat"))
            uniquelyList.add(Uniquely(R.drawable.uniquely_yours_time_capsule, "Time Capsule"))
            uniquelyList.add(Uniquely(R.drawable.uniquely_yourse_repeat_rewind, "Rewind"))
            uniquelyList.add(Uniquely(R.drawable.uniquely_yours_top_gulf, "Gulf"))
        }
        //Uniquely Yours - recycler view
        val uniquelyAdapter = UniquelyAdapter(uniquelyList, this@HomeFragment)
        val gridLayoutManagerUniqely =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerViewUniquely.adapter = uniquelyAdapter
        recyclerViewUniquely.layoutManager = gridLayoutManagerUniqely
        recyclerViewUniquely.hasFixedSize()


        //Setting RecyclerView Data for Artists
        listOfArtists.clear()
        for (i in 1..1) {
            listOfArtists.add(PopularArtists(R.drawable.artist_image_arijit_singh, "Arijit Singh"))
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_justin_bieber,
                    "Justin Bieber"
                )
            )
            listOfArtists.add(PopularArtists(R.drawable.artist_image_dua_lipa, "Dua Lipa"))
            listOfArtists.add(PopularArtists(R.drawable.artist_image_taylor_swift, "Taylor Swift"))
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_jubin_nautiyal,
                    "Jubin Nautiyal"
                )
            )
            listOfArtists.add(PopularArtists(R.drawable.artist_image_blackpink, "BLACKPINK"))
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_aurora_aksnes,
                    "Aurora Aksnes"
                )
            )
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_shreya_ghoshal,
                    "Shreya Ghoshal"
                )
            )
            listOfArtists.add(
                PopularArtists(
                    R.drawable.artist_image_pritam_chakraborty,
                    "Pritam Chakraborty"
                )
            )
            listOfArtists.add(PopularArtists(R.drawable.artist_image_bts, "BTS"))
        }
        listOfArtists.shuffle()


        //for artists list rcv
        val artistGridLayoutManager =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        val artistAdapter = ArtistAdapter(listOfArtists, this@HomeFragment)
        rcvListOfArtists.adapter = artistAdapter
        rcvListOfArtists.layoutManager = artistGridLayoutManager
        rcvListOfArtists.hasFixedSize()



        //Setting RecyclerView Data for Throwback
        workoutList.clear()
        for (i in 1..1) {
            workoutList.add(Workout(R.drawable.wokout_hits, "Hindi"))
            workoutList.add(Workout(R.drawable.workout_beast, "Beast"))
            workoutList.add(Workout(R.drawable.workout_beast_woman, "Woman"))
            workoutList.add(Workout(R.drawable.workout_cardio, "Cardio"))
            workoutList.add(Workout(R.drawable.workout_dance, "Dance"))
            workoutList.add(Workout(R.drawable.workout_hype, "Hype"))
            workoutList.add(Workout(R.drawable.workout_power, "Power"))
            workoutList.add(Workout(R.drawable.workout_workout, "Workout"))
            workoutList.add(Workout(R.drawable.workout_workout_beats, "Beats"))
        }
        workoutList.shuffle()
        //throwback - recycler view
        val workoutAdapter = WorkoutAdapter(workoutList, this@HomeFragment)
        val gridLayoutManagerWorkout =
            GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
        recyclerWorkout.adapter = workoutAdapter
        recyclerWorkout.layoutManager = gridLayoutManagerWorkout
        recyclerWorkout.hasFixedSize()



    }


    // artist click listerner
    override fun onArtistClick(position: Int, artists: PopularArtists) {
        val args = Bundle()
        args.putString("artistName", artists.artistName)
        args.putString("artistImage", artists.artistImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()

//        Toast.makeText(context, "Artist", Toast.LENGTH_SHORT).show()
    }


    // to get you started - mood click listener
    override fun onMoodClick(position: Int, mood: ToGetYouStarted) {
        val args = Bundle()
        args.putString("artistName", mood.title)
        args.putString("artistImage", mood.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()

//        Toast.makeText(context, "Mood", Toast.LENGTH_SHORT).show()
    }


    // Throwback click listener
    override fun onThrowClick(position: Int, throwback: ThrowBack) {
        val args = Bundle()
        args.putString("artistName", throwback.title)
        args.putString("artistImage", throwback.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()

    }

    override fun onIndiaBest(position: Int, indiaBest: IndiaBest) {
        val args = Bundle()
        args.putString("artistName", indiaBest.title)
        args.putString("artistImage", indiaBest.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onChartClick(position: Int, chart: Chart) {
        val args = Bundle()
        args.putString("artistName", chart.title)
        args.putString("artistImage", chart.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onUniquelyClick(position: Int, uniquely: Uniquely) {
        val args = Bundle()
        args.putString("artistName", uniquely.title)
        args.putString("artistImage", uniquely.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onToGetYouStartedOnClick(
        position: Int,
        toGetYouStartedFirst: ToGetYouStartedFirst
    ) {
        val args = Bundle()
        args.putString("artistName", toGetYouStartedFirst.title)
        args.putString("artistImage", toGetYouStartedFirst.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onWorkoutClick(position: Int, workout: Workout) {
        val args = Bundle()
        args.putString("artistName", workout.title)
        args.putString("artistImage", workout.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onArijitClick(position: Int, arijit: Arijit) {
        val args = Bundle()
        args.putString("artistName", arijit.title)
        args.putString("artistImage", arijit.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onRecommendedClick(position: Int, recommended: Recommended) {
        val args = Bundle()
        args.putString("artistName", recommended.title)
        args.putString("artistImage", recommended.albumImage.toString())

        val artistFragment = ArtistFragment()
        artistFragment.arguments = args

        val ft: FragmentTransaction = parentFragmentManager.beginTransaction()

        ft.replace(
            R.id.framelayout_container,
            artistFragment,
            "Fragment"
        )
        ft.addToBackStack(null)
        ft.commit()
    }

}