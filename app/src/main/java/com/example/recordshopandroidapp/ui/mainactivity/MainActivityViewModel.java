package com.example.recordshopandroidapp.ui.mainactivity;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.recordshopandroidapp.model.Album;
import com.example.recordshopandroidapp.model.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    AlbumRepository albumRepository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);


    }

    public MutableLiveData<List<Album>> getAlbums() {
        return albumRepository.getAlbumsMutableLiveData();
    }
    public void addAlbum(Album albumInput) {
        albumRepository.insertAlbum(albumInput);
    }


}
