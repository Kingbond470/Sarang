package com.example.sarang.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_final_payment.*

class FinalPaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_payment)
        paymentProcess()
    }

    private fun paymentProcess() {
        Handler().postDelayed({
            payment_processText.text = "Payment Done !!"
            payment_processText.visibility = View.GONE
            payment_processAnimation.visibility = View.GONE
            AlertDialog.Builder(this)
                .setView(R.layout.dialog_success)
                .create().show()
            paymentDone()
        }, 4000)
    }

    private fun paymentDone() {
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("intent", "success")
            startActivity(intent)
            finish()
        }, 2000)
    }
}
