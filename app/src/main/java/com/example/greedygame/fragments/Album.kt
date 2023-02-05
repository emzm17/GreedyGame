package com.example.greedygame.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.greedygame.DetailActivity
import com.example.greedygame.Globalvalue.Companion.TAG
import com.example.greedygame.R
import com.example.greedygame.adapter.AlbumAdapter
import com.example.greedygame.album.AlbumX
import com.example.greedygame.album.Artist
import com.example.greedygame.custom.DetailAA
import com.example.greedygame.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.fragment_album.*
import kotlinx.android.synthetic.main.fragment_artist.*


class Album : Fragment() {
    private lateinit var list:ArrayList<AlbumX>
    private lateinit var adapter:AlbumAdapter
    private lateinit var vm:MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_album, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
           vm= ViewModelProvider(this)[MusicViewModel::class.java]
           vm.topAlbum(TAG!!)
           list= ArrayList()
           adapter= AlbumAdapter(requireContext(),list)
           rcview.setHasFixedSize(true)
           rcview.layoutManager= GridLayoutManager(requireContext(),2)
           vm.albumlist.observe(viewLifecycleOwner){
                        it.albums.album.forEach { i->
                               list.add(i)
                        }
                 adapter.notifyDataSetChanged()
           }

         rcview.adapter=adapter
        adapter.onItemClick={
            val intent= Intent(activity, DetailActivity::class.java)
            val detailaa=DetailAA(it.artist.name,it.name)
            intent.putExtra("ALBUM",detailaa)
            activity?.startActivity( intent)
        }
    }


}