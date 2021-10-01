package com.example.sarang.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.FragmentTransaction
import com.example.sarang.R
import kotlinx.android.synthetic.main.fragment_sign_up_phone_number.*

class SignUpPhoneNumber : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_phone_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etNumberSignUp.doAfterTextChanged {
            if (etNumberSignUp.text.toString().trim().length == 10) {
                val ft: FragmentTransaction = parentFragmentManager.beginTransaction()
                ft.replace(R.id.containerSignUp, SignUpNumberOTPFragment(), "OTP Fragment")
                ft.addToBackStack(null)
                ft.commit()
            }
        }

    }

}