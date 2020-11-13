package com.example.android.localstorage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener { validateInputs() }
        buttonSignup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun validateInputs() {
        when {
            text_input_email.editText?.text?.isEmpty()!! -> {
                text_input_email.error = "Email required."
                text_input_email.requestFocus()
                return
            }
            text_input_password.editText?.text?.isEmpty()!! -> {
                text_input_password.error = "Password required."
                text_input_password.requestFocus()
                return
            }
            else -> {
                loginUser(
                    text_input_email.editText?.text.toString(),
                    text_input_password.editText?.text.toString()
                )
            }
        }
    }

    private fun loginUser(_email: String, _password: String) {
        val mPref = getSharedPreferences("detailsSupplied", Context.MODE_PRIVATE)
        val email = mPref.getString("email".plus(_email), "")
        val password = mPref.getString("password".plus(_email), "")

        if (email.equals(_email, true)) {
            if (password.equals(_password)) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Incorrect Password.", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Incorrect Email Address.", Toast.LENGTH_LONG).show()
        }
    }
}