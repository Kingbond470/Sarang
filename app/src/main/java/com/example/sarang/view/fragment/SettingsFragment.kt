package com.example.sarang.view.fragment

import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_library.*
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {

    //profile
    private lateinit var mAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //profile
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        Glide.with(ivSettingProfileImage).load(user!!.photoUrl).into(ivSettingProfileImage)
        tvSettingsProfileName.setText(user!!.displayName)
        ivEmail.setText(user!!.email)

        ivBackSettings.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                HomeFragment(),
                "Home Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()
        }

        if (spinnerSettingDownload.count > 1) {
            spinnerSettingDownload.setSelection(1)
        }

        seekbarSettingCrossfade.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    if (progress >= 0 && progress <= seekBar.max) {
                        val progressString = (progress).toString() + " s"
                        tvCrossfade12s.text = progressString // the TextView Reference
                        seekBar.secondaryProgress = progress
                    }
                }
            }
        })

        //for storage
        val statFs = StatFs(Environment.getDataDirectory().absolutePath);
        var total = (statFs.blockCount.toFloat() * statFs.blockSize) / 1048576;
        var free = (statFs.availableBlocks.toFloat() * statFs.blockSize) / 1048576;
        total /= 1024
        free /= 1024
        total = String.format("%.1f", total).toFloat()
        free = String.format("%.1f", free).toFloat()

        val busy = String.format("%.1f", (total - free)).toFloat()

        indicator.max = total.toInt()
        indicator.progress = busy.toInt()
        tvFreeSpace.text = "$free GB"
        tvUsedSpace.text = "$busy GB"

        val cache = context?.cacheDir.toString()
        tvCacheSpace.text = "2.2 MB"

        llDeleteCache.setOnClickListener {
            context?.cacheDir?.deleteRecursively()
            rlCache.visibility = View.GONE
        }

    }

}