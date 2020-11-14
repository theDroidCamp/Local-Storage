package com.example.android.localstorage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)




        logoutButton.setOnClickListener {

            //To display the Login next screen

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
    private fun displayData() {
        val a = name_edit_text.getText().toString()
        val b = email_edit_text.getText().toString()
        val c = school_edit_text.getText().toString()

        val detailsSupplied = getSharedPreferences("detailsSupplied", Context.MODE_PRIVATE)
        nameTxt.setText(detailsSupplied.getString("name"," "))
        emailTxt.setText(detailsSupplied.getString("email"," "))
        schoolTxt.setText(detailsSupplied.getString("school"," "))


    }

}