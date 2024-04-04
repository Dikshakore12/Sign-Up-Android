package com.example.myapplicationone

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterName = findViewById<EditText>(R.id.etName)
        val enterEmail = findViewById<EditText>(R.id.etEmail)
        val enterPassword = findViewById<EditText>(R.id.etPassword)
        val enterAboutMe = findViewById<EditText>(R.id.etAboutMe)
        val female = findViewById<RadioButton>(R.id.radioButton)
        val male = findViewById<RadioButton>(R.id.radioButton2)
        val java = findViewById<CheckBox>(R.id.java)
        val android = findViewById<CheckBox>(R.id.kotlin)
        val cpp = findViewById<CheckBox>(R.id.cpp)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val clearBtn = findViewById<Button>(R.id.clearBtn)
        val datePicker = findViewById<EditText>(R.id.etDate)
        val nameSpinner = findViewById<TextView>(R.id.CountryNames)

        submitBtn.setOnClickListener {
            Toast.makeText(this, "Data Received", Toast.LENGTH_SHORT).show()

            val name: String = enterName.text.toString()
            val email: String = enterEmail.text.toString()
            val password: String = enterPassword.text.toString()
            val about: String = enterAboutMe.text.toString()

            if (name.trim().isEmpty()) {
                enterName.setError("Enter Name!!")
            }

            val gender: String = if (female.isChecked) {
                "female"
            } else if (male.isChecked) {
                "male"
            } else {
                "other"
            }

            val courses = mutableListOf<String>()
            if (java.isChecked) {
                courses.add("Java")
            }
            if (cpp.isChecked) {
                courses.add("C++")
            }
            if (android.isChecked) {
                courses.add("Android")
            }

            val coursesString = courses.joinToString(", ")

            Log.w("Name", name)
            Log.w("Email", email)
            Log.w("About", about)
            Log.w("Gender", gender)
            Log.w("Courses", coursesString)
        }

        datePicker.setOnClickListener {
            showDatePicker()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
            },
            year,
            month,
            dayOfMonth
        )
        datePickerDialog.show()
    }
}
