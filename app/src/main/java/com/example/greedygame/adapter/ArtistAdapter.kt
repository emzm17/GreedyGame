package com.example.greedygame.adapter

import com.example.greedygame.artist.ArtistX


import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.greedygame.R
import com.example.greedygame.album.Album
import com.example.greedygame.album.AlbumX
import com.example.greedygame.album.Artist
import com.example.greedygame.tags.Tag
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.genre_item.view.*
import kotlinx.android.synthetic.main.music_item.view.*

class ArtistAdapter(private var context: Context, private var list:ArrayList<ArtistX>):
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {
    var onItemClick1:((ArtistX)->Unit)?=null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ArtistViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.music_item,parent,false)
        return ArtistViewHolder(view)
    }

    override fun onBindViewHolder(holder:ArtistViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            onItemClick1?.invoke(list[position])
        }
    }

    override fun getItemCount(): Int {
         return list.size
    }
    class ArtistViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(item: ArtistX)=with(itemView){
            artist_nametv.text=item.name
            album_nametv.text=item.name
            Picasso.get().load(item.image[3].text).into(album_pic)
        }

    }

}