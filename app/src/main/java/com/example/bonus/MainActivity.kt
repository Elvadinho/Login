package com.example.bonus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.util.Patterns
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: Button
    private lateinit var text: TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        text = findViewById(R.id.text)
        password = findViewById(R.id.password)
        loginBtn = findViewById(R.id.loginBtn)


        val signBtn = findViewById<Button>(R.id.signBtn)
        text.text = "Welcome Back😁"

        loginBtn.isEnabled = false

        email.addTextChangedListener {
            validateInput()
        }

        password.addTextChangedListener {
            validateInput()
        }

        loginBtn.setOnClickListener {
            if (email.text.isEmpty()) {
                text.text = "Enter Email"
            } else if (password.text.toString() == "") {
                text.text = "Enter password"
            } else {
                text.text = "Login successful"
            }

            val intent = Intent(this, LandingActivity::class.java)
            startActivity((intent))
        }

        signBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity((intent))
        }
    }
    private fun validateInput() {
        val emailText = email.text.toString()
        val passwordText = password.text.toString()

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailText).matches()
        val isPasswordValid = passwordText.length >= 8

        loginBtn.isEnabled = isEmailValid && isPasswordValid
    }
}