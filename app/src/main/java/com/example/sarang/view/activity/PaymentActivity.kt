package com.example.sarang.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    var isClick = false
    var amount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        btn_confirm.setOnClickListener {
            val intent = Intent(this, PaymentOptionActivity::class.java)
            intent.putExtra("amount", amount)
            startActivity(intent)

        }
    }
    fun selectPlant(linearLayout: LinearLayout){

    }
}