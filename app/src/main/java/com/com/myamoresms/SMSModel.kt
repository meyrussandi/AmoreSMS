package com.com.myamoresms

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SMSModel (
        var day: String? = null,
        var time: String? = null,
        var date: String? = null,
        var pesan: String? = null,
        var penerima: List<Penerima>? = null
):Parcelable

@Parcelize
data class Penerima (
        var idPenerima: String? = null,
        var nomerPenerima: String? = null,
        var status: String? = null,
        var namaPenerima: String? = null
):Parcelable{

}