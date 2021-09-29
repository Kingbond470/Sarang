package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.sarang.R
import kotlinx.android.synthetic.main.fragment_notification.*


class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivBackNotification.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(com.example.sarang.R.id.framelayout_container, HomeFragment(), "Home Fragment")
            ft.addToBackStack(null)
            ft.commit()
        }
    }


}