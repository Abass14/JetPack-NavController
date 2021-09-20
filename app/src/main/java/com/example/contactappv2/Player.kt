package com.example.contactappv2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player (val theText: String?, val image: Int, val phone: String?, val email: String?) : Parcelable
