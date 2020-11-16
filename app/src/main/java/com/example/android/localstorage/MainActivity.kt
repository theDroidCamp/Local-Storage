    package com.example.android.localstorage

    import android.content.Context
    import android.content.Intent
    import android.os.Bundle
    import android.text.TextUtils
    import android.widget.EditText
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import com.example.android.localstorage.databinding.ActivityMainBinding
    import kotlinx.android.synthetic.main.activity_main.*

    class MainActivity : AppCompatActivity() {

        lateinit var binding: ActivityMainBinding
        lateinit var nameEditText: EditText
        lateinit var emailEditText: EditText
        lateinit var schoolEditText: EditText
        lateinit var passwordEditText: EditText

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            nameEditText = binding.nameEditText
            emailEditText = binding.emailEditText
            schoolEditText = binding.schoolEditText
            passwordEditText = binding.passwordEditText

            binding.signUpButton.setOnClickListener{ collectData()
                //To display the details entered on the next screen

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

        //    Validates if all data are entered
        private fun IsEntered(): Boolean {
            var detailsEntered = true
            if (TextUtils.isEmpty(nameEditText.text) || TextUtils.isEmpty(emailEditText.text) ||
                TextUtils.isEmpty(schoolEditText.text) || TextUtils.isEmpty(passwordEditText.text)) {
                Toast.makeText(this, "All inputs are required for creation", Toast.LENGTH_SHORT).show()
                detailsEntered = false
            }

            return detailsEntered
        }

        // Collects user data and stores them
        private fun collectData() {
            if (IsEntered()) {
                val detailsSupplied = getSharedPreferences("detailsSupplied", Context.MODE_PRIVATE)
                val entered = detailsSupplied.edit()

              entered.putString("name".plus(emailEditText.text.toString()), nameEditText.text.toString())
                entered.putString("email".plus(emailEditText.text.toString()), emailEditText.text.toString())
                entered.putString("school".plus(emailEditText.text.toString()), schoolEditText.text.toString())
              entered.putString("password".plus(emailEditText.text.toString()), passwordEditText.text.toString())

                entered.apply()

                Toast.makeText(this, "Details saved", Toast.LENGTH_SHORT).show()
            }
        }
    }