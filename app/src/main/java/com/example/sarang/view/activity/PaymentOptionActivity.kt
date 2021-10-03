package com.example.sarang.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sarang.R
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import kotlinx.android.synthetic.main.activity_payment_option.*
import org.json.JSONObject

class PaymentOptionActivity : AppCompatActivity(), PaymentResultListener {
    var amount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)

        Checkout.preload(this)

        amount = intent.getIntExtra("amount", 0)
        pay_amount.text = amount.toString()

        // Payment with Razorpay

        razorpay.setOnClickListener {
            payWithRazorpay()
        }
    }

    private fun payWithRazorpay() {

        val checkout = Checkout()

        try {
            val options = JSONObject()
            options.put("name", "Razorpay Corp")
            options.put("description", "Demoing Charges")
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("currency", "INR")
            options.put("amount", "100")
            options.put("send_sms_hash", true);

            val prefill = JSONObject()
            prefill.put("email", "test@razorpay.com")
            prefill.put("contact", "9021066696")

            options.put("prefill", prefill)
            checkout.open(this, options)
        } catch (e: Exception) {
            Toast.makeText(this, "Payment failed: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Payment failed", Toast.LENGTH_SHORT).show()
    }
}