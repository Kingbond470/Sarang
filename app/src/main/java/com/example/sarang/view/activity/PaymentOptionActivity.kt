package com.example.sarang.view.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_payment_option.*


class PaymentOptionActivity : AppCompatActivity(){

    // Implementation ==>PaymentResultListener

    private val GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user"
    private val GOOGLE_PAY_REQUEST_CODE = 123
    var amount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)

//       Checkout.preload(this)

        amount = intent.getIntExtra("amount", 0)
        amount = 200
        pay_amount.text = amount.toString()

        // Payment with Razorpay

        razorpay.setOnClickListener {
//            payWithRazorpay()
        }

        // Payment with Google pay

        btn_googlePay.setOnClickListener {
            payWithGooglePay()
        }
    }

    private fun payWithGooglePay() {
        var uri:Uri = Uri.parse("upi://pay").buildUpon()
            .appendQueryParameter("pa", "hearthacker.mgr@okhdfcbank") // virtual ID
            .appendQueryParameter("pn", "heart hacker") // name
            .appendQueryParameter("tn", "your-transaction-note") // any note about payment
            .appendQueryParameter("am", "1") // amount
            .appendQueryParameter("cu", "INR") // currency
            .build()

        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = uri
        intent.setPackage(GOOGLE_PAY_PACKAGE_NAME)
       this@PaymentOptionActivity.startActivityForResult(intent,GOOGLE_PAY_REQUEST_CODE)
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
//        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPaymentError(p0: Int, p1: String?) {
//        Toast.makeText(this, "Payment failed", Toast.LENGTH_SHORT).show()
//    }
}