package com.example.sarang.view.activity

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_sarang_pay.*

class SarangPayActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sarang_pay)

        // Payment Cancel
        btn_cancelPayment.setOnClickListener {
            startActivity(Intent(this, PaymentActivity::class.java))
            finish()
        }

        // Select another Payment method
        btn_selectAnother.setOnClickListener {
            startActivity(Intent(this, PaymentOptionActivity::class.java))
            finish()
        }

        // Visibility validation

        enter_cardNumber.doAfterTextChanged {
            if (enter_cardNumber.text.toString().trim().length == 16) {
                enter_cardNumber.nextClusterForwardId = R.id.enter_cvvNumber
                enter_cvvNumber.doAfterTextChanged {
                    if (enter_cvvNumber.text.toString().length == 3) {
                        enter_date.doAfterTextChanged {
                            if (enter_date.text.toString().trim().length == 5
                                && enter_cardNumber.text.toString().trim().length == 16
                            ) {
                                btn_sendOTP.visibility = View.VISIBLE
                            }
                        }
                    }
                }
            }
        }

        // After click on Send OTP Button
        btn_sendOTP.setOnClickListener {
            enter_OTP.visibility = View.VISIBLE
        }

        // Enter OTP
        enter_OTP.doAfterTextChanged {
            if (enter_OTP.text.toString().trim().length == 5) {
                btn_verifyOTP.visibility = View.VISIBLE
            }
        }

        // After click on Verify OTP Button
        btn_verifyOTP.setOnClickListener {
            btn_verifyOTP.text = "Please wait...."
            Handler().postDelayed({
                btn_verifyOTP.text = "Verified"
                btn_verifyOTP.setBackgroundColor(Color.GREEN)
            }, 1500)
        }
        // Button pay
        btn_pay.setOnClickListener {
            startActivity(Intent(this, SuccessActivity::class.java))
        }
    }


}