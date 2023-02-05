package com.example.greedygame.repository

import com.example.greedygame.api.RetrofitHelper

object MusicRepository {

    suspend fun  Toplist()=RetrofitHelper.api.getTags()
    suspend fun  Topartist(tag:String)=RetrofitHelper.api.getArtist(tag)
    suspend fun  Topalbum(tag:String)=RetrofitHelper.api.getAlbums(tag)
    suspend fun  Toptrack(tag:String)=RetrofitHelper.api.getTrack(tag)
    suspend fun  AlbumInfo(artist:String,album:String)=RetrofitHelper.api.getAlbumInfo(artist,album)
    suspend fun ArtistInfo(artist: String)=RetrofitHelper.api.getArtistInfo(artist)
    suspend fun TagInfo(tag: String)=RetrofitHelper.api.getTaginfo(tag)
    suspend fun Artisttoptrack(artist: String)=RetrofitHelper.api.gettopTrack(artist)
    suspend fun Artisttopalbum(artist: String)=RetrofitHelper.api.gettopAlbum(artist)
}