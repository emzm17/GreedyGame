package com.example.greedygame.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.greedygame.Globalvalue
import com.example.greedygame.R
import com.example.greedygame.adapter.AlbumAdapter
import com.example.greedygame.adapter.ArtistAdapter
import com.example.greedygame.album.AlbumX
import com.example.greedygame.artist.ArtistX
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm= ViewModelProvider(this)[MusicViewModel::class.java]
        vm.topArtist(Globalvalue.TAG!!)
        list= ArrayList()
        adapter= ArtistAdapter(requireContext(),list)
        vm.artistlist.observe(viewLifecycleOwner){
            it.topartists.artist.forEach { i->
                list.add(i)
            }
            adapter.notifyDataSetChanged()
        }

        gdview1.adapter=adapter
    }

}