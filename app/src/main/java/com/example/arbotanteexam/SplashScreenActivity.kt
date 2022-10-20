package com.example.arbotanteexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.arbotanteexam.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        val username = sharedPreferences.getString(USER_NAME,"")
        if(username == ""){
            binding.welcomeMessage.text = String.format("Welcome to my application!")
        }
        else{
            binding.welcomeMessage.text = String.format("Welcome to my application, %s!",sharedPreferences.getString(
                USER_NAME,""))
        }

        object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }.start()

    }
}