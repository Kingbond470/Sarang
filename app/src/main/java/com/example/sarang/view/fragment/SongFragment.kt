package com.example.sarang.view.fragment

import android.os.Bundle
import android.support.v4.media.session.PlaybackStateCompat
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.sarang.R
import com.example.sarang.data.database.Song
import com.example.sarang.exoplayer.isPlaying
import com.example.sarang.exoplayer.toSong
import com.example.sarang.other.Status
import com.example.sarang.viewModel.MainViewModel
import com.example.sarang.viewModel.SongViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_song.*
import kotlinx.android.synthetic.main.fragment_song_home.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import android.content.Intent
import com.example.sarang.view.adapter.BaseSongAdapter
import com.example.sarang.view.adapter.SwipeSongAdapter
import kotlinx.android.synthetic.main.activity_song_playing.*
import kotlinx.android.synthetic.main.fragment_search_songs_item.view.*


@AndroidEntryPoint
class SongFragment : Fragment(R.layout.fragment_song) {

    @Inject
    lateinit var glide: RequestManager

    private lateinit var mainViewModel: MainViewModel
    private val songViewModel: SongViewModel by viewModels()

    private var curPlayingSong: Song? = null

    private var playbackState: PlaybackStateCompat? = null

    private var shouldUpdateSeekbar = true

    //private lateinit var swipeSongAdapter: SwipeSongAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        //swipeSongAdapter = Vie
        subscribeToObservers()

        ivPlayPauseDetail.setOnClickListener {
            curPlayingSong?.let {
                mainViewModel.playOrToggleSong(it, true)
            }
        }


        //val song = swipeSongAdapter.songs

        /*ivShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(
                Intent.EXTRA_TEXT,
                song.get(1).title +
                        " -\n\n" + song.get(1).songUrl + "\n\n" + "~ via Sarang \uD83D\uDCE3"
            )
            intent.type = "text/plain"
            requireContext().startActivity(Intent.createChooser(intent, "Send To"))
        }*/

        ivDownArrow.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.navHostFragment,
                SongHomeFragment(),
                "Song Home Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    setCurPlayerTimeToTextView(progress.toLong())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                shouldUpdateSeekbar = false
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.let {
                    mainViewModel.seekTo(it.progress.toLong())
                    shouldUpdateSeekbar = true
                }
            }
        })

        ivSkipPrevious.setOnClickListener {
            mainViewModel.skipToPreviousSong()
        }

        ivSkip.setOnClickListener {
            mainViewModel.skipToNextSong()
        }
    }

    private fun updateTitleAndSongImage(song: Song) {
        val title = "${song.title} - ${song.subtitle}"
        tvSongName.text = title
        glide.load(song.imageUrl).into(ivSongImage)
    }

    private fun subscribeToObservers() {
        mainViewModel.mediaItems.observe(viewLifecycleOwner) {
            it?.let { result ->
                when (result.status) {
                    Status.SUCCESS -> {
                        result.data?.let { songs ->
                            if (curPlayingSong == null && songs.isNotEmpty()) {
                                curPlayingSong = songs[0]
                                updateTitleAndSongImage(songs[0])
                            }
                        }
                    }
                    else -> Unit
                }
            }
        }
        mainViewModel.curPlayingSong.observe(viewLifecycleOwner) {
            if (it == null) return@observe
            curPlayingSong = it.toSong()
            updateTitleAndSongImage(curPlayingSong!!)
        }
        mainViewModel.playbackState.observe(viewLifecycleOwner) {
            playbackState = it
            ivPlayPauseDetail.setImageResource(
                if (playbackState?.isPlaying == true) R.drawable.ic_music_control_pause
                else R.drawable.ic_music_control_play
            )
            seekBar.progress = it?.position?.toInt() ?: 0
        }
        songViewModel.curPlayerPosition.observe(viewLifecycleOwner) {
            if (shouldUpdateSeekbar) {
                seekBar.progress = it.toInt()
                setCurPlayerTimeToTextView(it)
            }
        }
        songViewModel.curSongDuration.observe(viewLifecycleOwner) {
            seekBar.max = it.toInt()
            val milliseconds: Long = it
            val minutes = milliseconds / 1000 / 60
            val seconds = milliseconds / 1000 % 60
            val strintMin: String = minutes.toString()
            val strintSec: String = seconds.toString()
            if (strintMin.length == 1 && strintSec.length == 1) {
                val startTime: String = "0${minutes}:0${seconds}"
                tvSongDuration.text = startTime
            } else if (strintMin.length == 1 || strintSec.length == 1) {
                if (strintMin.length == 1) {
                    val startTime: String = "0${minutes}:${seconds}"
                    tvSongDuration.text = startTime
                } else {
                    val startTime: String = "${minutes}:0${seconds}"
                    tvSongDuration.text = startTime
                }
            } else {
                val startTime: String = "${minutes}:${seconds}"
                tvSongDuration.text = startTime
            }
        }
    }

    private fun setCurPlayerTimeToTextView(ms: Long) {
        //val dateFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
        val milliseconds: Long = ms
        val minutes = milliseconds / 1000 / 60
        val seconds = milliseconds / 1000 % 60
        val strintMin: String = minutes.toString()
        val strintSec: String = seconds.toString()
        if (strintMin.length == 1 && strintSec.length == 1) {
            val startTime: String = "0${minutes}:0${seconds}"
            tvCurTime.text = startTime
        } else if (strintMin.length == 1 || strintSec.length == 1) {
            if (strintMin.length == 1) {
                val startTime: String = "0${minutes}:${seconds}"
                tvCurTime.text = startTime
            } else {
                val startTime: String = "${minutes}:0${seconds}"
                tvCurTime.text = startTime
            }
        } else {
            val startTime: String = "${minutes}:${seconds}"
            tvCurTime.text = startTime
        }
    }
}