package com.com.myamoresms

data class SMSModel (
        val day: String? = null,
        val time: String? = null,
        val date: String? = null,
        val pesan: String? = null,
        val penerima: List<Penerima>? = null
)

data class Penerima (
        val idPenerima: String? = null,
        val nomerPenerima: String? = null,
        val status: String? = null,
        val namaPenerima: String? = null
)