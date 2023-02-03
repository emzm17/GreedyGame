package com.example.greedygame.api


import com.example.greedygame.ablum.Album
import com.example.greedygame.ablum.Artist
import com.example.greedygame.artist.Artists
import com.example.greedygame.constants.Constants.Companion.API_KEY
import com.example.greedygame.tags.Tags
import com.example.greedygame.track.Track
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("?method=tag.getTopTags&api_key=${API_KEY}&format=json")
    suspend fun getTags():Response<Tags>

    @GET("?method=tag.gettopalbums&api_key=${API_KEY}&format=json&")
    suspend fun getAlbums(@Query("tag")tag:String):Response<Album>

    @GET("?method=tag.gettopartists&api_key=${API_KEY}&format=json&")
    suspend fun getArtist(@Query("tag")tag:String):Response<Artists>


    @GET("?method=tag.gettoptracks&api_key=${API_KEY}&format=json&")
    suspend fun getTrack(@Query("tag")tag: String):Response<Track>




}