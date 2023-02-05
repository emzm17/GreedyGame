package com.example.greedygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greedygame.adapter.DetailAlbumAdapter
import com.example.greedygame.adapter.DetailTrackAdapter
import com.example.greedygame.adapter.TopAlbumAdapter
import com.example.greedygame.adapter.TopArtistAdapter
import com.example.greedygame.artisittopalbum.Album
import com.example.greedygame.artistinfo.Tag
import com.example.greedygame.artisttoptrack.Track
import com.example.greedygame.viewmodel.MusicViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_artist.*

class DetailArtistActivity : AppCompatActivity() {
    private lateinit var vm:MusicViewModel
    private lateinit var tracklist:ArrayList<Track>
    private lateinit var albumlist:ArrayList<Album>
    private lateinit var topAlbumAdapter: TopAlbumAdapter
    private lateinit var topTrackAdapter: TopArtistAdapter
    private lateinit var detailTrackAdapter: DetailTrackAdapter
    private lateinit var taglist:ArrayList<Tag>
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_artist)
        albumlist= ArrayList()
        tracklist= ArrayList()
        taglist= ArrayList()
        topAlbumAdapter= TopAlbumAdapter(this,albumlist)
        topTrackAdapter= TopArtistAdapter(this,tracklist)
        detailTrackAdapter= DetailTrackAdapter(this,taglist)
        vm= ViewModelProvider(this)[MusicViewModel::class.java]
        val artist=intent.getStringExtra("ARTIST")
        vm.artisttoptrack(artist!!)
        vm.artisttopalbum(artist)
        vm.artistinfo(artist)
        vm.artistInfolist.observe(this){
                  Picasso.get().load(it.artist.image[3].text).into(detail_artist_pic)
                  details_top_artist_nametv.text=it.artist.name
                  details_playcount_tv.text=it.artist.stats.playcount
                  details_listener_tv.text=it.artist.stats.listeners
                  details_toptrack_descri.text=it.artist.bio.summary
                  taglist.clear()
                  it.artist.tags.tag.forEach { i ->
                      taglist.add(i)

                  }
            detailTrackAdapter.notifyDataSetChanged()
        }
        vm.albumtop.observe(this){
                   it.album.forEach { i->
                        albumlist.add(i)
                   }
              topAlbumAdapter.notifyDataSetChanged()
        }
        vm.tracktop.observe(this){
            it.track.forEach { i->
                tracklist.add(i)
            }
            topTrackAdapter.notifyDataSetChanged()
        }
        setup()



    }
    private fun setup(){
        detail_tag_rcivew.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        detail_tag_rcivew.adapter=detailTrackAdapter
        detail_toptrack_rcivew.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        detail_toptrack_rcivew.adapter=topTrackAdapter
        detail_topalbum_rcivew.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        detail_topalbum_rcivew.adapter=topAlbumAdapter
    }

}