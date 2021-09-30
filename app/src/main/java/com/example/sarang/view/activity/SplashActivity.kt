package com.example.sarang.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sarang.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, SignUpActivity::class.java)
            startActivity(intent)

            /*val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                // User is signed in
                val i = Intent(this@SplashActivity, MainActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            } else {
                // User is signed out
                val i = Intent(this@SplashActivity, SignUp::class.java)
                startActivity(i)
                Log.d("SIGNOUT", "onAuthStateChanged:signed_out")
            }*/

            finish()
        }, 2000)

    }
}