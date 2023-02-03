package com.example.greedygame.repository

import com.example.greedygame.api.RetrofitHelper

object MusicRepository {

    suspend fun  Toplist()=RetrofitHelper.api.getTags()
    suspend fun  Topartist(tag:String)=RetrofitHelper.api.getArtist(tag)
    suspend fun  Topalbum(tag:String)=RetrofitHelper.api.getAlbums(tag)
    suspend fun  Toptrack(tag:String)=RetrofitHelper.api.getTrack(tag)

}