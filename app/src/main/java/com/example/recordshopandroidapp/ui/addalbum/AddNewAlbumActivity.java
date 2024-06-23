package com.example.recordshopandroidapp.ui.addalbum;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.example.recordshopandroidapp.R;
import com.example.recordshopandroidapp.databinding.ActivityAddNewAlbumBinding;
import com.example.recordshopandroidapp.model.Album;
import com.example.recordshopandroidapp.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private ActivityAddNewAlbumBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_add_new_album);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        Album albumInput = new Album();
        binding.setAlbum(albumInput);

        AddAlbumClickHandlers handlers = new AddAlbumClickHandlers(albumInput,this,mainActivityViewModel);
        binding.setClickHandlers(handlers);
    }
}