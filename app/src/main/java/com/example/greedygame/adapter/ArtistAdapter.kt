package com.example.greedygame.adapter

import com.example.greedygame.artist.ArtistX


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.example.greedygame.R
import com.example.greedygame.album.Album
import com.example.greedygame.album.AlbumX
import com.example.greedygame.album.Artist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_item.view.*

class ArtistAdapter(private var context: Context, private var list:ArrayList<ArtistX>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val v=View.inflate(context,R.layout.music_item,null)
        v.artist_nametv.text=list[position].name
        v.album_nametv.text=list[position].name
        Picasso.get().load(list[position].image[3].text).into(v.album_pic)
        return v
    }
}