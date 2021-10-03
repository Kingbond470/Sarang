package com.example.sarang.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sarang.R

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
       Handler().postDelayed({
           val intent= Intent(this,MainActivity::class.java)
           intent.putExtra("intent","success")
           startActivity(intent)
           finish()
       },2000)
    }
}
