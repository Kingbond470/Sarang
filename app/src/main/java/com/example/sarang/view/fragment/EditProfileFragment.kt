package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.example.sarang.R
import kotlinx.android.synthetic.main.fragment_edit_profile.*

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivEditProfileBack.setOnClickListener {
            val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
            ft.replace(
                R.id.framelayout_container,
                SettingsFragment(),
                "Settings Fragment"
            )
            ft.addToBackStack(null)
            ft.commit()
        }

    }

}