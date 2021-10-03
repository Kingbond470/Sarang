package com.example.sarang.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_payment_option.*

class PaymentOptionActivity : AppCompatActivity() {
    var amount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)

//        Checkout.preload(this)

        amount = intent.getIntExtra("amount", 0)
        amount = 200
        pay_amount.text = amount.toString()

        // Payment with Razorpay

        razorpay.setOnClickListener {
//            payWithRazorpay()
        }
    }

//    private fun payWithRazorpay() {
//
//        val checkout = Checkout()
//        val  activity = this
//        try {
//            val options = JSONObject()
//            options.put("name", "Razorpay Corp")
//            options.put("description", "Demoing Charges")
//            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
//            options.put("currency", "INR")
//            options.put("amount", "$amount")
//            options.put("send_sms_hash", true);
//
//            val prefill = JSONObject()
//            prefill.put("email", "prabhakar@sarang.com")
//            prefill.put("contact", "6206950235")
//
//            options.put("prefill", prefill)
//            checkout.open(activity, options)
//        } catch (e: Exception) {
//            Toast.makeText(activity, "Payment failed: " + e.message, Toast.LENGTH_LONG).show()
//            e.printStackTrace()
//        }
//    }
//
//    override fun onPaymentSuccess(p0: String?) {
//        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPaymentError(p0: Int, p1: String?) {
//        Toast.makeText(this, "Payment failed", Toast.LENGTH_SHORT).show()
//    }
}