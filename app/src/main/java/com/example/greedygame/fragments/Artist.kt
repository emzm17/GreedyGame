package com.example.greedygame.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.greedygame.DetailActivity
import com.example.greedygame.DetailArtistActivity
import com.example.greedygame.Globalvalue
import com.example.greedygame.R
import com.example.greedygame.adapter.AlbumAdapter
import com.example.greedygame.adapter.ArtistAdapter
import com.example.greedygame.album.AlbumX
import com.example.greedygame.artist.ArtistX
import com.example.greedygame.custom.DetailAA
import com.example.greedygame.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.fragment_album.*
import kotlinx.android.synthetic.main.fragment_artist.*


class Artist : Fragment() {

    private lateinit var list:ArrayList<ArtistX>
    private lateinit var adapter: ArtistAdapter
    private lateinit var vm:MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artist, container, false)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm= ViewModelProvider(this)[MusicViewModel::class.java]
        vm.topArtist(Globalvalue.TAG!!)
        list= ArrayList()
        adapter= ArtistAdapter(requireContext(),list)
        rcview1.setHasFixedSize(true)
        rcview1.layoutManager=GridLayoutManager(requireContext(),2)
        vm.artistlist.observe(viewLifecycleOwner){
            it.topartists.artist.forEach { i->
                list.add(i)
            }
            adapter.notifyDataSetChanged()
        }

        rcview1.adapter=adapter
        adapter.onItemClick1={
            val intent= Intent(activity, DetailArtistActivity::class.java)
            intent.putExtra("ARTIST",it.name)
            activity?.startActivity( intent)
        }
    }

}