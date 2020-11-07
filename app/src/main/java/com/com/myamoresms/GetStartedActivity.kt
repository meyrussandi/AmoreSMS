package com.com.myamoresms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GetStartedActivity : AppCompatActivity() {

    private lateinit var btnMulai : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        btnMulai = findViewById(R.id.btnMulai)

        btnMulai.setOnClickListener{
            startActivity(Intent(this,InputPhoneNumberActivity::class.java))
            finish()
        }
    }
}