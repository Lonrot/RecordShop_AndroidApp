package com.example.recordshopandroidapp.model;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshopandroidapp.service.AlbumAPIService;
import com.example.recordshopandroidapp.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepository {

    private MutableLiveData<List<Album>> albumsMutableLiveData = new MutableLiveData<>();
    private Application application;


    public AlbumRepository(Application application) {
        this.application = application;
    }
    
    public MutableLiveData<List<Album>> getAlbumsMutableLiveData() {
        AlbumAPIService APIservice = RetrofitInstance.getService();

        Call<List<Album>> call = APIservice.getAlbums();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {

                    List<Album> albums = response.body();
                    albumsMutableLiveData.setValue(albums);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable throwable) {

            }
        });
        return this.albumsMutableLiveData;
    }
    
}
