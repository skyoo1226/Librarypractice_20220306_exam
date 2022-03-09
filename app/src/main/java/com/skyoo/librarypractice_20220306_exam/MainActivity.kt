package com.skyoo.librarypractice_20220306_exam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setEvents()
        setValues()
    }

    fun setEvents() {

        imgProfile.setOnClickListener {

//            사진 크게 보는 화면으로 넘어가자. 단, 그전에 ViewPhotoActivity.kt라는 액티비티를 만들어야 함.
            val myIntent = Intent(this, ViewPhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    fun setValues() {

    }
}