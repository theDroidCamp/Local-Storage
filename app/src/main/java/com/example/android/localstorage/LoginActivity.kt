package com.example.android.localstorage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        removeTextInputErrors()
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
        val mPref = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val email = mPref.getString(Constants.EMAIL_PREF, "")
        val password = mPref.getString(Constants.PASSWORD_PREF, "")

        if (email.equals(_email, true)) {
            if (password.equals(_password)) {
                // TODO: Use an Intent and navigate to UserDetailsActivity
            } else {
                Toast.makeText(this, "Incorrect Password.", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Incorrect Email Address.", Toast.LENGTH_LONG).show()
        }
    }

    private fun removeTextInputErrors() {
        text_input_email.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    text_input_email.error = null
                }
            }
        })

        text_input_password.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().trim().isNotEmpty()) {
                    text_input_password.error = null
                }
            }
        })
    }
}