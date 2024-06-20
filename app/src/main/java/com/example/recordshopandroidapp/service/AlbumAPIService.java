package com.example.recordshopandroidapp.service;

import com.example.recordshopandroidapp.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumAPIService {

    @GET("/album")
    Call<List<Album>> getAlbums();
}
