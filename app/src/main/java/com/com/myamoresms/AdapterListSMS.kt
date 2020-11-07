package com.com.myamoresms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterListSMS(private val listSMS:List<SMSModel>) : RecyclerView.Adapter<Holder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(
            onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount(): Int = listSMS.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.sms(listSMS[position])
        holder.itemView.setOnClickListener(){
            onItemClickCallback.onItemClick(listSMS[holder.adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_sms, parent,false))
    }


    interface OnItemClickCallback {
        fun onItemClick(dataSMSModel: SMSModel )
    }

}

class  Holder(view: View) : RecyclerView.ViewHolder(view){
    private val tvJam = view.findViewById<TextView>(R.id.Jam)
    private val tvDate = view.findViewById<TextView>(R.id.tanggal)

    fun sms(smsModel: SMSModel){
        tvJam.text = smsModel.time
    }

}
