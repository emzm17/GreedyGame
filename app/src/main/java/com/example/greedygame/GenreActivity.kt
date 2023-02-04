package com.example.greedygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.PagerAdapter
import com.example.greedygame.Globalvalue.Companion.TAG
import com.example.greedygame.adapter.ViewPagerAdapter
import com.example.greedygame.fragments.Album
import com.example.greedygame.fragments.Artist
import com.example.greedygame.fragments.Track
import com.example.greedygame.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.activity_genre.*

class GenreActivity : AppCompatActivity() {
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var vm:MusicViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)
        val bundle=intent.extras
        val tagname=bundle!!.getString("TAG")
        TAG=tagname
        vm= ViewModelProvider(this)[MusicViewModel::class.java]
        vm.taginfo(tagname!!)
        vm.tagInfolist.observe(this){
              genre_titletv.text=it.tag.name.capitalize()
              genre_descritv.text=it.tag.wiki.summary
        }
        adapter=ViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addto(Album(),"ALBUM")
            addto(Artist(),"ARTIST")
            addto(Track(),"TRACK")
        }
        viewpager.adapter = adapter
        tablayout.setupWithViewPager(viewpager)

    }
}