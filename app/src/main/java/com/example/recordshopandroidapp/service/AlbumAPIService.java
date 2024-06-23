package com.example.recordshopandroidapp.service;

import com.example.recordshopandroidapp.model.Album;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


import java.util.List;

public interface AlbumAPIService {

    @GET("album")
    Call<List<Album>> getAlbums();
    @POST("add")
    Call<Album> addAlbum(@Body Album album);

}
