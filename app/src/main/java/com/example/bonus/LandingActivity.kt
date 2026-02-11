package com.example.bonus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LandingActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val emailTextView = findViewById<TextView>(R.id.email_text_view)
        val phoneTextView = findViewById<TextView>(R.id.phone_text_view)
        val genderTextView = findViewById<TextView>(R.id.gender_text_view)
        val logoutBtn = findViewById<Button>(R.id.logoutBtn)

        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val gender = intent.getStringExtra("gender")

        emailTextView.text = "Email: $email"
        phoneTextView.text = "Phone: $phone"
        genderTextView.text = "Gender: $gender"

        logoutBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}