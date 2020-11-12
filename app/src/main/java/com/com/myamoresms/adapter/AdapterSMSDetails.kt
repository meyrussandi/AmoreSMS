package com.com.myamoresms.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.com.myamoresms.R
import com.com.myamoresms.model.Penerima

class AdapterSMSDetails(private var listSmsDetails: List<Penerima>?) : RecyclerView.Adapter<HolderSmsDetails>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderSmsDetails {
        return HolderSmsDetails(LayoutInflater.from(parent.context).inflate(R.layout.list_sms_detail, parent, false))
    }

    override fun onBindViewHolder(holder: HolderSmsDetails, position: Int) {
        holder.penerimaSms(listSmsDetails!![position])
    }

    override fun getItemCount(): Int {
        return listSmsDetails?.size!!
    }
}

class  HolderSmsDetails(view: View) : RecyclerView.ViewHolder(view){
    private val tvNamaPenerima = view.findViewById<TextView>(R.id.namaPenerima)
    private val tvNomer = view.findViewById<TextView>(R.id.noPenerima)
    private val btnStatus = view.findViewById<Button>(R.id.statusPesan)

    fun penerimaSms(penerima: Penerima){
        tvNamaPenerima.text = penerima.namaPenerima
        tvNomer.text = penerima.nomerPenerima
        if (penerima.status.equals("Error",true)){
            btnStatus.setBackgroundResource(R.drawable.ic_error)
        }else if(penerima.status.equals("Delivered",true)){
            btnStatus.setBackgroundResource(R.drawable.ic_delivered)
        }else{
            btnStatus.visibility = View.INVISIBLE
        }
    }

}