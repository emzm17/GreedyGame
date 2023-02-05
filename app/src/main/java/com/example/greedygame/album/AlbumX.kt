package com.example.greedygame.album

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class AlbumX(
    val attr: AttrX,
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    val name: String,
    val url: String
)