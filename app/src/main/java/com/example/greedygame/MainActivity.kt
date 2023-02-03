package com.example.greedygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.greedygame.tags.Toptags
import com.example.greedygame.viewmodel.MusicViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var vm:MusicViewModel
    private lateinit var tags:ArrayList<Toptags>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      tags= ArrayList()
      vm=ViewModelProvider(this)[MusicViewModel::class.java]
        vm.topAlbum("disco")
        vm.topArtist("disco")
        vm.topTrack("disco")
        try{
          vm.artistlist.observe(this){
               it.topartists.artist.forEach {  i->
                   Log.i("ARTIST",i.name)
               }
          }

      }catch (e:Exception){
          Log.i("ERROR",e.toString())
      }
    }
}