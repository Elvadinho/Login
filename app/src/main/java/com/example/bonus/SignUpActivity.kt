package com.example.bonus

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.content.edit

class SignUpActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var signupBtn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        phoneEditText = findViewById(R.id.phone)
        genderRadioGroup = findViewById(R.id.gender_radio_group)
        signupBtn = findViewById(R.id.signupBtn)

        signupBtn.isEnabled = false

        emailEditText.addTextChangedListener { validateFields() }
        passwordEditText.addTextChangedListener { validateFields() }
        phoneEditText.addTextChangedListener { validateFields() }
        genderRadioGroup.setOnCheckedChangeListener { _, _ -> validateFields() }

        signupBtn.setOnClickListener {
            // Save user data
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val genderRadioButton = findViewById<RadioButton>(selectedGenderId)
            val gender = genderRadioButton.text.toString()

            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            sharedPreferences.edit {
                putString("email", email)
                putString("password", password)
                putString("phone", phone)
                putString("gender", gender)
            }

            // Navigate to LandingActivity
            val intent = Intent(this, LandingActivity::class.java).apply {
                putExtra("email", email)
                putExtra("phone", phone)
                putExtra("gender", gender)
            }
            startActivity(intent)
            finish()
        }
    }

    private fun validateFields() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val genderSelected = genderRadioGroup.checkedRadioButtonId != -1

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length >= 8
        val isPhoneValid = phone.isNotEmpty()

        signupBtn.isEnabled = isEmailValid && isPasswordValid && genderSelected && isPhoneValid
    }
}