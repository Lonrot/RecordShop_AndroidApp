package com.example.recordshopandroidapp.service;

import com.example.recordshopandroidapp.model.Album;
import retrofit2.Call;
import retrofit2.http.*;


import java.util.List;

public interface AlbumAPIService {

    @GET("album")
    Call<List<Album>> getAlbums();

    @POST("album/add")
    Call<Album> addAlbum(@Body Album album);

    @PUT("update/{id}")
    Call<Album> updateAlbum( @Path ("id") long id, @Body Album album);

    @DELETE("delete/{id}")
    Call<Album> deleteAlbum( @Path ("id") long id);
}
