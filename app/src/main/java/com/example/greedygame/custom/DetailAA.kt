package com.example.greedygame.custom

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailAA (
    val artist_name:String,
    val album_name:String
    ):Parcelable