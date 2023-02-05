package com.example.greedygame.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame.GenreActivity
import com.example.greedygame.R
import com.example.greedygame.albuminfo.Tag
import com.example.greedygame.albuminfo.Tags
import kotlinx.android.synthetic.main.tag_item.view.*

class DetailAlbumAdapter(private var context: Context, private var list: ArrayList<Tag>):RecyclerView.Adapter<DetailAlbumAdapter.DetailAlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAlbumViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.tag_item,parent,false)
        return DetailAlbumViewHolder(view)
    }

    override fun onBindViewHolder(holder: DetailAlbumViewHolder, position: Int) {
         holder.bind(list[position])
         holder.itemView.setOnClickListener {
             val intent= Intent(context,GenreActivity::class.java)
             val bundle= Bundle()
             bundle.putString("TAG",list[position].name)
             intent.putExtras(bundle)
             startActivity(context, intent, null)
         }
    }

    override fun getItemCount(): Int {
         return list.size
    }
    class DetailAlbumViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(item: Tag)=with(itemView){
            detail_tagtv.text=item.name
        }
    }
}