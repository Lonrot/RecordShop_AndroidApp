package com.example.recordshopandroidapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordshopandroidapp.databinding.ActivityMainBinding;
import com.example.recordshopandroidapp.model.Album;
import com.example.recordshopandroidapp.ui.mainactivity.MainActivityClickHandler;
import com.example.recordshopandroidapp.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Album> albums;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize ActivityMainBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // Initialize MainActivityViewModel
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        // Initialize the album list
        albums = new ArrayList<>();

        MainActivityClickHandler handlers = new MainActivityClickHandler(this);
        binding.setClickHandlers(handlers);

        // Sending hardcoded album to test POST
       // mainActivityViewModel.addHardcodedAlbum();

        // Call method to get all albums
        getAllAlbums();


    }

    private void getAllAlbums() {
        mainActivityViewModel.getAlbums().observe(this, new Observer<List<Album>>() {

            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                // albums refers to the variable name of your List of Album objects
                // albumsFromLiveData is cast to this type
                albums = (ArrayList<Album>) albumsFromLiveData;

                // This method will be created next
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        // Assign RecyclerView variable to binding.recyclerView
        recyclerView = binding.recyclerView;

        // Assign AlbumAdapter variable to a new AlbumAdapter
        albumAdapter = new AlbumAdapter(albums);

        // Set the RecyclerView adapter
        recyclerView.setAdapter(albumAdapter);

        // Create and set a new LinearLayoutManager
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set RecyclerView's setHasFixedSize to true
        recyclerView.setHasFixedSize(true);

        // Notify the adapter that the data set has changed
        albumAdapter.notifyDataSetChanged();
    }


}