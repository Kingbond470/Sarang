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
import com.example.sarang.R
import kotlinx.android.synthetic.main.fragment_recently_played.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        val busy = total - free;
        indicator.max = total.toInt()
        indicator.progress = busy.toInt()
        tvFreeSpace.text = "$free GB"
        tvUsedSpace.text = "$busy GB"

        llDeleteCache.setOnClickListener {
            rlCache.visibility = View.GONE
        }

    }

}

/*

        //for storage
        val totalSpace: Float = DeviceMemory().getInternalStorageSpace()
        val outputFormat = DecimalFormat("#.##")

        if (null != indicator) {
            indicator.max = totalSpace.toInt()
            indicator.progress = DeviceMemory().getInternalUsedSpace().toInt()
        }
        if (null != freeSpace) {
//            freeSpaceText.text = outputFormat.format(freeSpace) + " MB"
            freeSpace.text = outputFormat.format("${DeviceMemory().getInternalFreeSpace()} MB")
        }

        if (null != occupiedSpace) {
//            occupiedSpaceText.setText(outputFormat.format(occupiedSpace) + " MB");
            occupiedSpace.text = outputFormat.format("${DeviceMemory().getInternalUsedSpace()} MB")
        }

    }

    class DeviceMemory {

        fun getInternalStorageSpace(): Float {
            val statFs = StatFs(Environment.getDataDirectory().absolutePath);
            //StatFs statFs = new StatFs("/data");
            val total = (statFs.blockCount.toFloat() * statFs.blockSize) / 1048576;
            return total.toFloat();
        }

        fun getInternalFreeSpace(): Float {
            val statFs = StatFs(Environment.getDataDirectory().absolutePath);
            //StatFs statFs = new StatFs("/data");
            val free  = (statFs.availableBlocks.toFloat() * statFs.blockSize) / 1048576;
            return free;
        }

        fun getInternalUsedSpace(): Float {
            val statFs = StatFs(Environment.getDataDirectory().absolutePath);
            //StatFs statFs = new StatFs("/data");
            val total = (statFs.blockCount.toFloat() * statFs.blockSize) / 1048576;
            val free  = (statFs.availableBlocks.toFloat() * statFs.blockSize) / 1048576;
            val busy  = total - free;
            return busy;
        }
    }
 */