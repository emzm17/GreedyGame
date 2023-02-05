package com.example.greedygame.adapter



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
import com.example.greedygame.artist.ArtistX
import com.example.greedygame.track.TrackX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.music_item.view.*
class TrackAdapter(private var context: Context, private var list:ArrayList<TrackX>):
    RecyclerView.Adapter<TrackAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrackAdapter.TrackViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.music_item,parent,false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder:TrackViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class TrackViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        fun bind(item: TrackX)=with(itemView){
            artist_nametv.text=item.name
            album_nametv.text=item.artist.name
            Picasso.get().load(item.image[3].text).into(album_pic)
        }

    }

}