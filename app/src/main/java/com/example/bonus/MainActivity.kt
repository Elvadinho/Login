package com.example.bonus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.email)
//        val phone = findViewById<EditText>(R.id.phone)
        val text = findViewById<TextView>(R.id.text)
        val password = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val signBtn = findViewById<Button>(R.id.signBtn)
        text.text = "Welcome"

        loginBtn.isEnabled = false

        email.addTextChangedListener{
            password.addTextChangedListener {
                if (email.text.isNotEmpty()  && password.text.isNotEmpty()) {
                    loginBtn.isEnabled = true
                }
            }
        }

        loginBtn.setOnClickListener{
           if(email.text.isEmpty()){
               text.text = "Enter Email"
           }else if(password.text.toString() == ""){
               text.text = "Enter password"
           }else{
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
}