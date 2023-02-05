package com.example.greedygame.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame.R
import  com.example.greedygame.artisittopalbum.Album
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_list_item.view.*
import kotlinx.android.synthetic.main.top_list_item1.view.*

class TopAlbumAdapter(private var context: Context, private var list:ArrayList<Album>):RecyclerView.Adapter<TopAlbumAdapter.TopAlbumViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAlbumViewModel {
        return TopAlbumViewModel(
            LayoutInflater.from(context).inflate(R.layout.top_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopAlbumViewModel, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class TopAlbumViewModel(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(item:Album)= with(itemView){
            Picasso.get().load(item.image[3].text).into(top_album_pic)
            top_album_name.text=item.name
            top_artist_name.text=item.artist.name

        }
    }
}