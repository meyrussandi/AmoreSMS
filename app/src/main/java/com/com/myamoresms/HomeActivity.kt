package com.com.myamoresms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recycler = findViewById<RecyclerView>(R.id.recyclerViewHome)

        val listSMS = listOf(
                SMSModel(day = "Monday",time = "13:00", date = "02 Januari 2020",pesan = "Hallo Apa Kabar",
                        penerima = listOf(Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered",namaPenerima = "Andi"))
                )
        )

        val smsAdapter = AdapterListSMS(listSMS)

        recycler.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = smsAdapter
        }

    }
}