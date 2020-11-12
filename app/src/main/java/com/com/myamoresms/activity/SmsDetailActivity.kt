package com.com.myamoresms.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.com.myamoresms.model.Penerima
import com.com.myamoresms.R
import com.com.myamoresms.adapter.AdapterSMSDetails

@SuppressWarnings("ConstantConditions")
class SmsDetailActivity : AppCompatActivity() {
    private lateinit var smsDetailsAdapter : AdapterSMSDetails

    companion object{
        const val EXTRA_PESAN = "extra_pesan"
        const val EXTRA_PENERIMA = "extra_penerima"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_detail)

        val pesan = findViewById<TextView>(R.id.textPesan)

        pesan.text = intent.getStringExtra(EXTRA_PESAN)
        val bundle = intent.extras
        val penerimaSMS = bundle?.getParcelableArrayList<Penerima>(EXTRA_PENERIMA)

        val recycler = findViewById<RecyclerView>(R.id.recyclerViewDetail)
        smsDetailsAdapter = AdapterSMSDetails(penerimaSMS)
        recycler.apply {
            layoutManager = LinearLayoutManager(this@SmsDetailActivity)
            adapter = smsDetailsAdapter
            setHasFixedSize(true)
        }
    }
}