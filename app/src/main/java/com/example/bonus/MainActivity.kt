package com.example.bonus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginBtn: Button
    private lateinit var welcomeText: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.email)
        welcomeText = findViewById(R.id.text)
        passwordEditText = findViewById(R.id.password)
        loginBtn = findViewById(R.id.loginBtn)

        val signBtn = findViewById<Button>(R.id.signBtn)
        welcomeText.text = "Welcome Back😁"

        loginBtn.isEnabled = false



        emailEditText.addTextChangedListener { validateInput() }
        passwordEditText.addTextChangedListener { validateInput() }

        loginBtn.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            val storedEmail = sharedPreferences.getString("email", null)
            val storedPassword = sharedPreferences.getString("password", null)
            val storedPhone = sharedPreferences.getString("phone", null)
            val storedGender = sharedPreferences.getString("gender", null)

            if (email == storedEmail && password == storedPassword) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LandingActivity::class.java).apply {
                    putExtra("email", storedEmail)
                    putExtra("phone", storedPhone)
                    putExtra("gender", storedGender)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        signBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateInput() {
        val emailText = emailEditText.text.toString()
        val passwordText = passwordEditText.text.toString()

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
        val isPasswordValid = passwordText.length >= 8

        loginBtn.isEnabled = isEmailValid && isPasswordValid
    }
}