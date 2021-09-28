package com.example.sarang.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.sarang.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get input text
        val inputText = outlinedTextField.editText?.text.toString()

        outlinedTextField.editText?.doOnTextChanged { inputText, _, _, _ ->
            // Respond to input text change
        }
    }
}