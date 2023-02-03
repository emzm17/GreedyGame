package com.example.greedygame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.greedygame.ablum.Album
import com.example.greedygame.artist.Artists
import com.example.greedygame.tags.Toptags
import com.example.greedygame.repository.MusicRepository
import com.example.greedygame.track.Track
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MusicViewModel:ViewModel() {

    private val tagLiveData=MutableLiveData<Toptags>()
    val taglist:LiveData<Toptags>
    get() = tagLiveData


    private val albumLiveData= MutableLiveData<Album>()
    val albumlist:LiveData<Album>
    get() = albumLiveData

    private val artistLiveData= MutableLiveData<Artists>()
    val artistlist:LiveData<Artists>
    get() = artistLiveData



    private val trackLiveData= MutableLiveData<Track>()
    val tracklist:LiveData<Track>
    get() = trackLiveData





    fun topEverything() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = MusicRepository.Toplist()
            if (result.isSuccessful) {
                tagLiveData.postValue(result.body()!!.toptags!!)
            }
        }

    }

    fun topAlbum(tag:String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = MusicRepository.Topalbum(tag)
            if (result.isSuccessful) {
                albumLiveData.postValue(result.body())
            }
        }
    }

    fun topArtist(tag:String){
        viewModelScope.launch(Dispatchers.IO) {
          val result=MusicRepository.Topartist(tag)
          if(result.isSuccessful){
              artistLiveData.postValue(result.body())
          }
        }
    }

    fun topTrack(tag:String){
        viewModelScope.launch(Dispatchers.IO) {
            val result = MusicRepository.Toptrack(tag)
            if (result.isSuccessful) {
                trackLiveData.postValue(result.body())
            }
        }
    }



}