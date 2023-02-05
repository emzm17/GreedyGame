package com.example.greedygame.albuminfo

data class Track(
    val attr: Attr,
    val artist: Artist,
    val duration: Int,
    val name: String,
    val streamable: Streamable,
    val url: String
)