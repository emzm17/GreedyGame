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
import com.example.greedygame.adapter.TrackAdapter
import com.example.greedygame.album.AlbumX
import com.example.greedygame.track.TrackX
import com.example.greedygame.viewmodel.MusicViewModel
import kotlinx.android.synthetic.main.fragment_album.*
import kotlinx.android.synthetic.main.fragment_track.*


class Track : Fragment() {

    private lateinit var list:ArrayList<TrackX>
    private lateinit var adapter:TrackAdapter
    private lateinit var vm:MusicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_track, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm= ViewModelProvider(this)[MusicViewModel::class.java]
        vm.topTrack(Globalvalue.TAG!!)
        list= ArrayList()
        adapter= TrackAdapter(requireContext(),list)
        vm.tracklist.observe(viewLifecycleOwner){
              it.tracks.track.forEach {  i->
                   list.add(i)
              }
            adapter.notifyDataSetChanged()
        }

        gdview2.adapter=adapter
    }
}