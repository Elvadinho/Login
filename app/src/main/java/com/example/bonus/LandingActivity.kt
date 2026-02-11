package com.example.bonus

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import kotlin.random.Random

class LandingActivity : AppCompatActivity() {

    private var secretNumber = 0
    private var maxTries = 5
    private var triesLeft = 0

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

        val levelRadioGroup = findViewById<RadioGroup>(R.id.level_radio_group)
        val guessEditText = findViewById<TextInputEditText>(R.id.guess_edit_text)
        val guessButton = findViewById<Button>(R.id.guess_button)
        val feedbackTextView = findViewById<TextView>(R.id.feedback_text_view)

        levelRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedLevel = findViewById<RadioButton>(checkedId)
            val level = when (selectedLevel.id) {
                R.id.level1_radio -> 1
                R.id.level2_radio -> 2
                R.id.level3_radio -> 3
                else -> 1
            }
            startGame(level, feedbackTextView, guessButton, guessEditText)
        }

        guessButton.setOnClickListener {
            if (triesLeft <= 0) {
                feedbackTextView.text = "Please select a level to start a new game."
                return@setOnClickListener
            }

            val guessStr = guessEditText.text.toString()
            if (guessStr.isEmpty()) {
                feedbackTextView.text = "Please enter a guess."
                return@setOnClickListener
            }

            val guess = guessStr.toInt()
            triesLeft--

            when {
                guess < secretNumber -> {
                    feedbackTextView.text = "Too low! You have $triesLeft tries left."
                }
                guess > secretNumber -> {
                    feedbackTextView.text = "Too high! You have $triesLeft tries left."
                }
                else -> {
                    feedbackTextView.text = "Congratulations! You guessed the number."
                    Toast.makeText(this, "You won!", Toast.LENGTH_SHORT).show()
                    guessButton.isEnabled = false
                }
            }

            if (triesLeft == 0 && guess != secretNumber) {
                feedbackTextView.text = "You ran out of tries. The number was $secretNumber."
                guessButton.isEnabled = false
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun startGame(level: Int, feedbackTextView: TextView, guessButton: Button, guessEditText: TextInputEditText) {
        secretNumber = when (level) {
            1 -> Random.nextInt(0, 11)
            2 -> Random.nextInt(0, 101)
            3 -> Random.nextInt(0, 1001)
            else -> 0
        }

        triesLeft = maxTries
        feedbackTextView.text = "New game started. You have $triesLeft tries."
        guessButton.isEnabled = true
        guessEditText.text?.clear()
    }
}