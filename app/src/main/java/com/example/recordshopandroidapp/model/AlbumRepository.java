package com.example.recordshopandroidapp.model;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshopandroidapp.service.AlbumAPIService;
import com.example.recordshopandroidapp.service.RetrofitInstance;
import kotlin.reflect.KCallable;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> albumsMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Album> albumMutableLiveData = new MutableLiveData<>();
    private final Application application;


    public AlbumRepository(Application application) {
        this.application = application;
    }
    
    public MutableLiveData<List<Album>> getAlbumsMutableLiveData() {
        AlbumAPIService APIservice = RetrofitInstance.getService();

        Call<List<Album>> call = APIservice.getAlbums();

        Log.i("GET URL", call.request().url().toString());

        call.enqueue(new Callback<List<Album>>() {

            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                    List<Album> albums = response.body();
                    albumsMutableLiveData.setValue(albums);
                    Log.i("AlbumRepository", "onResponse: " + albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {
                Log.i("AlbumRepository", "onFailure: " + throwable.getMessage());
            }
        });
        return this.albumsMutableLiveData;
    }
    public void insertAlbum(Album albumInput) {
        AlbumAPIService APIservice = RetrofitInstance.getService();
        Call<Album> call = APIservice.addAlbum(albumInput);

        Log.i("POST URL", call.request().url().toString());
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(@NotNull Call<Album> call, @NotNull Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album added successfully", Toast.LENGTH_SHORT)
                        .show();
            }
            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),
                        "Album Insertion failed, you failed too :(", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
    public void updateAlbum(long ID, Album albumInput) {
        AlbumAPIService APIservice = RetrofitInstance.getService();

        Call<Album> call =APIservice.updateAlbum(ID, albumInput);
        Log.i("PUT CALL ", "URL: " + call.request().url());

        call.enqueue(new Callback<Album>() {

            @Override
            public void onResponse(@NotNull Call<Album> call, @NotNull Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),"Album updated successfully",Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onFailure(@NotNull Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),"Album update failed, you failed too :(", Toast.LENGTH_LONG)
                        .show();
                Log.e("PUT CALL ", "onFailure: " + throwable.getMessage() + " " + throwable.getLocalizedMessage());
            }
        });
    }
    public void deleteAlbum(long ID) {
        AlbumAPIService APIservice = RetrofitInstance.getService();
        Call<Album> call = APIservice.deleteAlbum(ID);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(@NotNull Call<Album> call, @NotNull Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),"Album deleted successfully",Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(@NotNull Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),"Album delete failed, you failed too :(", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendAlbumTestAPI() {
        Album album = new Album();
        album.setAlbumName("Test Album");
        album.setAlbumArtist("Test Artist");
        album.setAlbumReleaseYear("2024");
        album.setAlbumGenre("Rock");
        album.setAlbumLabel("Test label");
        album.setAlbumPrice(10.0);
        album.setAlbumStock(5);

        AlbumAPIService APIservice = RetrofitInstance.getService();
        Call<Album> call = APIservice.addAlbum(album);
        Log.i("POST URL HARDCODED ", "URL: " + call.request().url());

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(@NotNull Call<Album> call, @NotNull Response<Album> response) {
               Log.i("POST CALL ", "onResponse: " + response.code() + "  " + response.headers() + "  " + response.body());
            }

            @Override
            public void onFailure(@NotNull Call<Album> call, Throwable throwable) {
                Log.i("AlbumRepository TEST POST", "onFailure: " + throwable.getMessage() + " " + throwable.getLocalizedMessage());
            }
        });
    }



}


