package com.example.sarang.view.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.example.sarang.R
import com.example.sarang.view.activity.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import kotlinx.android.synthetic.main.fragment_settings.*

class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {

    //profile
    private lateinit var mAuth: FirebaseAuth

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

        //profile
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        if (user != null) {
            Glide.with(ivEditProfileImage).load(user.photoUrl).into(ivEditProfileImage)
            tvEditProfileName.text = user.displayName
        }

        tvEditLogout.setOnClickListener {
            mAuth.signOut()
            val logout = Intent(activity, SignUpActivity::class.java)
            startActivity(logout)
            (activity as Activity?)?.overridePendingTransition(0, 0)
        }

    }

}