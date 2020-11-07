package com.com.myamoresms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {
    private lateinit var smsAdapter : AdapterListSMS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recycler = findViewById<RecyclerView>(R.id.recyclerViewHome)

        val listSMS = listOf(
                SMSModel(day = "Monday", time = "13:00", date = "02 Januari 2020", pesan = "Hallo Apa Kabar",
                        penerima = listOf(
                                Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered", namaPenerima = "Andi"),
                                Penerima(idPenerima = "2", nomerPenerima = "089612348966", status = "Delivered", namaPenerima = "Arif"),
                                Penerima(idPenerima = "3", nomerPenerima = "089222248966", status = "error", namaPenerima = "ahmad"),
                                Penerima(idPenerima = "4", nomerPenerima = "089222248954", status = "Delivered", namaPenerima = "said"))
                ),
                SMSModel(day = "Monday", time = "11:00", date = "02 Januari 2020", pesan = "Hallooooo",
                        penerima = listOf(Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered", namaPenerima = "Andi"))
                ),
                SMSModel(day = "Tuesday", time = "09:00", date = "03 Januari 2020", pesan = "Hallooooo2",
                        penerima = listOf(Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered", namaPenerima = "Andi"))
                ),
                SMSModel(day = "Wednesday", time = "13:00", date = "02 Januari 2020", pesan = "Hallooooo3",
                        penerima = listOf(Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered", namaPenerima = "Andi"))
                ),
                SMSModel(day = "Thursday", time = "12:00", date = "02 Januari 2020", pesan = "Hallooooo4",
                        penerima = listOf(Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered", namaPenerima = "Andi"))
                ),
                SMSModel(day = "Friday", time = "14:00", date = "02 Januari 2020", pesan = "Hallooooo5",
                        penerima = listOf(Penerima(idPenerima = "1", nomerPenerima = "089612345678", status = "Delivered", namaPenerima = "Andi"))
                )
        )

        smsAdapter = AdapterListSMS(listSMS)

        recycler.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = smsAdapter
            setHasFixedSize(true)
        }

        setListClickAction()

    }

    private fun setListClickAction(){
        smsAdapter.setOnItemClickCallBack(
                object : AdapterListSMS.OnItemClickCallback{
                    override fun onItemClick(dataSMSModel: SMSModel) {
                        val manageDetailIntent = Intent(this@HomeActivity, SmsDetailActivity::class.java)
                                .apply {
                                    putExtra(SmsDetailActivity.EXTRA_PESAN, dataSMSModel.pesan)
//                                    putStringArrayListExtra(SmsDetailActivity.EXTRA_PENERIMA, )
                                }
                        val bundle = Bundle()
                        bundle.putParcelableArrayList(SmsDetailActivity.EXTRA_PENERIMA,listToArrayList(dataSMSModel.penerima))
                        manageDetailIntent.putExtras(bundle)
                        Log.d("pesan ", dataSMSModel.pesan.toString())
                        startActivity(manageDetailIntent)
                    }
                }
        )
    }

    private fun listToArrayList(list: List<Penerima>?):ArrayList<Penerima>{
        val arrayList = ArrayList<Penerima>()
        list?.forEach {
            arrayList.add(it)
            Log.d("nama : " , it.namaPenerima.toString())
        }
        return arrayList
    }
}