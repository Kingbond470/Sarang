package com.example.sarang.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_payment_option.*

class PaymentOptionActivity : AppCompatActivity() {
    var amount:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_option)
        amount= intent.getIntExtra("amount",0)
        pay_amount.text= amount.toString()
    }
}