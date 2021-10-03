package com.example.sarang.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.media.session.PlaybackStateCompat
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.RequestManager
import com.example.sarang.data.database.Song
import com.example.sarang.exoplayer.isPlaying
import com.example.sarang.exoplayer.toSong
import com.example.sarang.other.Status
import com.example.sarang.view.adapter.SwipeSongAdapter
import com.example.sarang.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_song_playing.*
import javax.inject.Inject
import androidx.navigation.findNavController
import com.example.sarang.R
import com.example.sarang.view.fragment.*

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {

    val mainViewModel: MainViewModel by viewModels()

    @Inject
    lateinit var swipeSongAdapter: SwipeSongAdapter

    @Inject
    lateinit var glide: RequestManager

    private var curPlayingSong: Song? = null

    private var playbackState: PlaybackStateCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCurrentFragment(HomeFragment())

        bottomNavBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> setCurrentFragment(HomeFragment())
                R.id.page_2 -> setCurrentFragment(SearchFragment())
                R.id.page_3 -> setCurrentFragment(LibraryFragment())
                R.id.page_4 -> setCurrentFragment(PremiumFragment())
            }
            true
        }

        //Added to favorites
        mivFavoriteWhite.setOnClickListener {
            mivFavoriteWhite.visibility = View.GONE
            mivFavoriteGreen.visibility = View.VISIBLE

            cdAddedToLikedSongs.visibility = View.VISIBLE
            tvAddedToLikedSongs.text = "Added To Liked Songs."

            Handler().postDelayed({
                this@MainActivity
                cdAddedToLikedSongs.visibility = View.GONE
            }, 2000)

        }

        //removed from favorites
        mivFavoriteGreen.setOnClickListener {
            mivFavoriteGreen.visibility = View.GONE
            mivFavoriteWhite.visibility = View.VISIBLE

            cdAddedToLikedSongs.visibility = View.VISIBLE
            tvAddedToLikedSongs.text = "Removed From Liked Songs."

            Handler().postDelayed({
                this@MainActivity
                cdAddedToLikedSongs.visibility = View.GONE
            }, 2000)
        }

        //implement song fragment
        /*mcdPlayingSong.setOnClickListener {

        }*/

        mivPlay.setOnClickListener {
            mivPlay.visibility = View.GONE
        }
        subscribeToObservers()

        mvpSong.adapter = swipeSongAdapter

        mvpSong.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (playbackState?.isPlaying == true) {
                    mainViewModel.playOrToggleSong(swipeSongAdapter.songs[position])
                } else {
                    curPlayingSong = swipeSongAdapter.songs[position]
                }
            }
        })

        mivPlayPause.setOnClickListener {
            curPlayingSong?.let {
                mainViewModel.playOrToggleSong(it, true)
            }
        }

    }

    private fun switchViewPagerToCurrentSong(song: Song) {
        val newItemIndex = swipeSongAdapter.songs.indexOf(song)
        if (newItemIndex != -1) {
            mvpSong.currentItem = newItemIndex
            curPlayingSong = song
        }
    }

    private fun subscribeToObservers() {
        mainViewModel.mediaItems.observe(this) {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { songs ->
                            swipeSongAdapter.songs = songs
                            if (songs.isNotEmpty()) {
                                glide.load((curPlayingSong ?: songs[0]).imageUrl)
                                    .into(mivCurSongImage)
                            }
                            switchViewPagerToCurrentSong(curPlayingSong ?: return@observe)
                        }
                    }
                    Status.ERROR -> Unit
                    Status.LOADING -> Unit
                }
            }
        }
        mainViewModel.curPlayingSong.observe(this) {
            if (it == null) return@observe

            curPlayingSong = it.toSong()
            glide.load(curPlayingSong?.imageUrl).into(mivCurSongImage)
            switchViewPagerToCurrentSong(curPlayingSong ?: return@observe)
        }
        mainViewModel.playbackState.observe(this) {
            playbackState = it
            mivPlayPause.setImageResource(
                if (playbackState?.isPlaying == true) R.drawable.ic_music_control_play_white_colour
                else R.drawable.ic_music_control_pause_white_colour
            )
        }
        mainViewModel.isConnected.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.ERROR -> Snackbar.make(
                        rootLayout,
                        result.message ?: "An unknown error occured",
                        Snackbar.LENGTH_LONG
                    ).show()
                    else -> Unit
                }
            }
        }
        mainViewModel.networkError.observe(this) {
            it?.getContentIfNotHandled()?.let { result ->
                when (result.status) {
                    Status.ERROR -> Snackbar.make(
                        rootLayout,
                        result.message ?: "An unknown error occured",
                        Snackbar.LENGTH_LONG
                    ).show()
                    else -> Unit
                }
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout_container, fragment)
                .commit()
        }
}