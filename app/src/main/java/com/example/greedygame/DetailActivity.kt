package com.example.greedygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greedygame.adapter.DetailAlbumAdapter
import com.example.greedygame.albuminfo.AlbumInfo
import com.example.greedygame.albuminfo.Tag
import com.example.greedygame.custom.DetailAA
import com.example.greedygame.viewmodel.MusicViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.*

class DetailActivity : AppCompatActivity() {
    private lateinit var vm:MusicViewModel
    private lateinit var adapter:DetailAlbumAdapter
    private  lateinit var list:ArrayList<AlbumInfo>
    private lateinit var taglist:ArrayList<Tag>
    @SuppressLint("NotifyDataSetChanged")
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        taglist= ArrayList()
        val detailaa=intent.getParcelableExtra<DetailAA>("ALBUM")
        list=ArrayList()
        vm= ViewModelProvider(this)[MusicViewModel::class.java]
        vm.albuminfo(detailaa!!.artist_name,detailaa.album_name)
        adapter= DetailAlbumAdapter(this,taglist)
        vm.albumInfolist.observe(this){
            Picasso.get().load(it.album.image[5].text).into(detail_album_pic)
            details_album_nametv.text=detailaa.album_name
            details_artist_nametv.text=detailaa.artist_name
            details_album_descri.text=it.album.wiki.summary
            taglist.clear()
            it.album.tags.tag.forEach { i->
                 taglist.add(i)
            }
            adapter.notifyDataSetChanged()
        }
        detail_album_rcivew.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        detail_album_rcivew.adapter=adapter
    }
}