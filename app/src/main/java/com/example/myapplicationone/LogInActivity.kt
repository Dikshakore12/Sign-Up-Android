package com.example.myapplicationone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login12)

        val submitButton = findViewById<Button>(R.id.submitBtn)

        submitButton.setOnClickListener {
            val emailEditText = findViewById<EditText>(R.id.etEmail)
            val passwordEditText = findViewById<EditText>(R.id.etPassword)
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, SignUp::class.java)
                startActivity(intent)

                finish()

                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        val signupButton = findViewById<Button>(R.id.createAcc)

        signupButton.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            Toast.makeText(this, "Creating New Account!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Activity Stopped!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Activity Paused!", Toast.LENGTH_SHORT).show()
    }
}
