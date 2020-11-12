package com.com.myamoresms.activity

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.com.myamoresms.R
import com.com.myamoresms.adapter.AdapterSMSDetails
import com.com.myamoresms.model.Penerima
import com.com.myamoresms.utils.RequestCode
import com.gun0912.tedpermission.TedPermissionBase
import kotlinx.android.synthetic.main.activity_pesan.*

class PesanActivity : AppCompatActivity() {

    private lateinit var smsAdapter : AdapterSMSDetails
    private var listNumberPhone : ArrayList<Penerima> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)

        btn_selectfile.setOnClickListener {

        }

        btn_addkontak.setOnClickListener {
            if(TedPermissionBase.isGranted(this, Manifest.permission.READ_CONTACTS)){
                val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
                intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
                startActivityForResult(intent, RequestCode().openContacts)
            }else{
                Toast.makeText(this,"Permission not Granted",Toast.LENGTH_LONG).show()
            }
        }
        onValueChangeAdapter(listNumberPhone)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == RequestCode().openContacts){
            var phoneNumber = ""
            var name = ""
            if(data != null){
                val uri = data.data
                val cursorLoader = contentResolver.query(uri!!,null,null,null,null)
                if (cursorLoader != null) {
                    if(cursorLoader.moveToFirst()){
                        val indexPhoneNumber = cursorLoader.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                        val indexNameContacts = cursorLoader.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                        phoneNumber = cursorLoader.getString(indexPhoneNumber)
                        name = cursorLoader.getString(indexNameContacts)
                    }
                    if(Penerima(nomerPenerima = phoneNumber, namaPenerima = name) in listNumberPhone){
                        Toast.makeText(this,"Duplicate Number Phone",Toast.LENGTH_LONG).show()
                    }else{
                        listNumberPhone.add(Penerima(nomerPenerima = phoneNumber, namaPenerima = name))
                        onValueChangeAdapter(listNumberPhone)
                    }
                }
                cursorLoader?.close()
            }
        }
    }

    fun onValueChangeAdapter(listNumberPhone: List<Penerima>) {
        smsAdapter = AdapterSMSDetails(listNumberPhone)
        smsAdapter.notifyDataSetChanged()
        recyclerViewSendMessages.apply {
            layoutManager = LinearLayoutManager(this@PesanActivity)
            adapter = smsAdapter
            setHasFixedSize(true)
        }
    }
}