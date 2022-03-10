package com.skyoo.librarypractice_20220306_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvent()
        setValues()
    }

    fun setupEvent() {

    }

    fun setValues() {

        val myHandler = Handler( Looper.getMainLooper())
        myHandler.postDelayed({
              val myIntent = Intent(this, MainActivity::class.java)
              startActivity(myIntent)

              finish()

        }, 3000)

    }
}