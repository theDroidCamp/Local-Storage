package com.example.android.localstorage

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.localstorage.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var message: TextView
    private lateinit var icon: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Declare the animation
        val textPlay = AnimationUtils.loadAnimation(this, R.anim.text_play)
        val iconPlay = AnimationUtils.loadAnimation(this, R.anim.icon_play)
        val button1 = AnimationUtils.loadAnimation(this, R.anim.button1_play)
        val button2 = AnimationUtils.loadAnimation(this, R.anim.button2_play)

        val message = binding.message as TextView
        val icon = binding.icon as ImageView
        val create = binding.createNew as Button
        val signIn = binding.signIn as Button

//        Set the animation
        message.startAnimation(textPlay)
        icon.startAnimation(iconPlay)
        create.startAnimation(button1)
        signIn.startAnimation(button2)

        // When the Buttons are clicked
        binding.createNew.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.signIn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}