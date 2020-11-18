package com.example.android.localstorage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.localstorage.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var schoolEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nameEditText = binding.nameEditText
        emailEditText = binding.emailEditText
        schoolEditText = binding.schoolEditText
        passwordEditText = binding.passwordEditText

        binding.signUpButton.setOnClickListener {
            collectData()
            //To display the details entered on the next screen
            if (isEntered()) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }

        }
    }

    //    Validates if all data are entered
    private fun isEntered(): Boolean {
        var detailsEntered = true
        if (TextUtils.isEmpty(nameEditText.text) || TextUtils.isEmpty(emailEditText.text) ||
            TextUtils.isEmpty(schoolEditText.text) || TextUtils.isEmpty(passwordEditText.text)
        ) {
            Toast.makeText(this, "All inputs are required for creation", Toast.LENGTH_SHORT).show()
            detailsEntered = false
        }

        return detailsEntered
    }

    // Collects user data and stores them
    private fun collectData() {
        if (isEntered()) {
            val detailsSupplied = getSharedPreferences("detailsSupplied", Context.MODE_PRIVATE)
            val entered = detailsSupplied.edit()

            entered.putString(
                "name".plus(emailEditText.text.toString()),
                nameEditText.text.toString()
            )
            entered.putString(
                "email".plus(emailEditText.text.toString()),
                emailEditText.text.toString()
            )
            entered.putString(
                "school".plus(emailEditText.text.toString()),
                schoolEditText.text.toString()
            )
            entered.putString(
                "password".plus(emailEditText.text.toString()),
                passwordEditText.text.toString()
            )

            entered.apply()

            Toast.makeText(this, "Details saved", Toast.LENGTH_SHORT).show()
        }
    }
}