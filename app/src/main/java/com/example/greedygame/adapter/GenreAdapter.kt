package com.example.greedygame.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.greedygame.GenreActivity
import com.example.greedygame.R
import com.example.greedygame.tags.Tag
import com.example.greedygame.tags.Toptags
import kotlinx.android.synthetic.main.genre_item.view.*

class GenreAdapter(private val context: Context,private val list:ArrayList<Tag>):RecyclerView.Adapter<GenreAdapter.GenreViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenreViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.genre_item,parent,false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
      holder.bind(list[position])
      holder.itemView.setOnClickListener{
           val intent= Intent(context,GenreActivity::class.java)
           val bundle= Bundle()
           bundle.putString("TAG",list[position].name)
           intent.putExtras(bundle)
           startActivity(context,intent,null)
      }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class GenreViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
              fun bind(item:Tag)=with(itemView){
                  name_tv.text=item.name
              }
    }

}
