package com.example.greedygame.api


import com.example.greedygame.album.Album
import com.example.greedygame.albuminfo.AlbumInfo
import com.example.greedygame.artisittopalbum.ArtistTopAlbum
import com.example.greedygame.artist.Artists
import com.example.greedygame.artistinfo.ArtistInfo
import com.example.greedygame.artisttoptrack.ArtistTopTrack
import com.example.greedygame.constants.Constants.Companion.API_KEY
import com.example.greedygame.taginfo.TagInfo
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

    @GET("?method=tag.getinfo&api_key=${API_KEY}&format=json&")
    suspend fun getTaginfo(@Query("tag")tag: String):Response<TagInfo>

    @GET("?method=artist.getinfo&api_key=${API_KEY}&format=json&")
    suspend fun getArtistInfo(@Query("artist")artist:String):Response<ArtistInfo>


    @GET("?method=album.getinfo&api_key=${API_KEY}&format=json&")
    suspend fun getAlbumInfo(@Query("artist")artist: String,@Query("album")album: String):Response<AlbumInfo>


    @GET("?method=artist.gettopalbums&api_key=${API_KEY}&format=json&")
    suspend fun gettopAlbum(@Query("artist")artist: String):Response<ArtistTopAlbum>

    @GET("?method=artist.gettoptracks&api_key=${API_KEY}&format=json&")
    suspend fun gettopTrack(@Query("artist")artist: String):Response<ArtistTopTrack>

}