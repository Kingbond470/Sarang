package com.example.sarang.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sarang.R
import com.example.sarang.view.fragment.SelectMusicFragment
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignUpFree.setOnClickListener {
            /*supportFragmentManager.beginTransaction().apply {
                replace(R.id.sign_up_framelayout_container, SelectMusicFragment())
                commit()
            }*/
            val intent = Intent(this@SignUpActivity, SongPlayingActivity::class.java)
            startActivity(intent)
        }
    }
}