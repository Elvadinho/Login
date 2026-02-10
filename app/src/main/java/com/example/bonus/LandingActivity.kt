package com.example.bonus

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val emailTextView = findViewById<TextView>(R.id.email_text_view)
        val phoneTextView = findViewById<TextView>(R.id.phone_text_view)
        val genderTextView = findViewById<TextView>(R.id.gender_text_view)

        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        emailTextView.text = "Email: $email"
        phoneTextView.text = "Phone: $phone"
        genderTextView.text = "Gender: $gender"
    }
}