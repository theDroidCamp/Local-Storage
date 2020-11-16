    package com.example.android.localstorage

    import android.content.Context
    import android.content.Intent
    import android.os.Bundle
    import android.widget.TextView
    import androidx.appcompat.app.AppCompatActivity
    import kotlinx.android.synthetic.*
    import kotlinx.android.synthetic.main.activity_main.*
    import kotlinx.android.synthetic.main.activity_profile.*



    class ProfileActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_profile)
            val givenname = findViewById<TextView>(R.id.nameTxt)
            val givenemail = findViewById<TextView>(R.id.emailTxt)
            val givenschool = findViewById<TextView>(R.id.schoolTxt)


//Get values from keys or return null if value is not set
            val detailsSupplied = getSharedPreferences("detailsSupplied", Context.MODE_PRIVATE)
            val currentname = detailsSupplied.getString("name", "")
            givenname.setText(currentname)

            val currentemail = detailsSupplied.getString("email", "")
            givenemail.setText(currentemail)

            val currentschool = detailsSupplied.getString("school", "")
            givenschool.setText(currentschool)


            //To logout when button is clicked
            logoutButton.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))

            }


        }


    }