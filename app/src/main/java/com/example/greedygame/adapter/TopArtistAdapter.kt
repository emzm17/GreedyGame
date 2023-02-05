package com.example.greedygame.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame.R
import com.example.greedygame.artisttoptrack.Toptracks
import com.example.greedygame.artisttoptrack.Track
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.top_list_item1.view.*

class TopArtistAdapter(private var context: Context,private var list:ArrayList<Track>):RecyclerView.Adapter<TopArtistAdapter.TopArtistViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopArtistViewModel {
       return TopArtistViewModel(LayoutInflater.from(context).inflate(R.layout.top_list_item1,parent,false))
    }

    override fun onBindViewHolder(holder: TopArtistViewModel, position: Int) {
         holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class TopArtistViewModel(itemView: View):RecyclerView.ViewHolder(itemView) {
             fun bind(item:Track)= with(itemView){
                  Picasso.get().load(item.image[2].text).into(top1_album_pic)
                  top1_track_name.text=item.name
                  top1_artist_name.text=item.artist.name
             }
    }
}