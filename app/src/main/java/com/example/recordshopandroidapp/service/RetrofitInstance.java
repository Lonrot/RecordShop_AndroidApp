package com.example.recordshopandroidapp.service;

import retrofit2.Retrofit;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "http://127.0.0.1:8080/api/v1/album";

    public static AlbumAPIService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).build();
        }
        return retrofit.create(AlbumAPIService.class);
    }
}
