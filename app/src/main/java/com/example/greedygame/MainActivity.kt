package com.example.greedygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.greedygame.adapter.GenreAdapter
import com.example.greedygame.tags.Tag
import com.example.greedygame.tags.Toptags
import com.example.greedygame.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var vm:MusicViewModel
    private lateinit var tags:ArrayList<Tag>
    private lateinit var adapter:GenreAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      tags= ArrayList()
      adapter= GenreAdapter(this,tags)
      vm=ViewModelProvider(this)[MusicViewModel::class.java]
      vm.topEverything()

      vm.taglist.observe(this){
          it.tag.forEach { i->
              tags.add(i)
          }
          adapter.notifyDataSetChanged()
      }
      rc_view.layoutManager=LinearLayoutManager(this)
      rc_view.adapter=adapter

    }
}