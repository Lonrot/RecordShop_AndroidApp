package com.example.recordshopandroidapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.recordshopandroidapp.MainActivity;
import com.example.recordshopandroidapp.model.Album;
import com.example.recordshopandroidapp.ui.mainactivity.MainActivityViewModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AddAlbumClickHandlers {
    private Album album;
    private MainActivityViewModel viewModel;
    private Context context;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = mainActivityViewModel;
    }

    public void onAddAlbumClick(View view) {
        if (album.getAlbumName() == null || album.getAlbumName().isEmpty() || album.getAlbumArtist() == null || album.getAlbumArtist().isEmpty() || album.getAlbumGenre() == null || album.getAlbumGenre().isEmpty() || album.getAlbumLabel() == null || album.getAlbumLabel().isEmpty() || album.getAlbumStock() <= 0 || album.getAlbumPrice() <= 0) {
            Toast.makeText(context, "Fields cannot be empty or zero", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!isValidGenre(album.getAlbumGenre())) {
            Toast.makeText(context, "Invalid genre. Please select a valid genre.", Toast.LENGTH_SHORT).show();
            return;
        }
        Album newAlbum = new Album(album.getAlbumID(), album.getAlbumName(), album.getAlbumArtist(), album.getAlbumReleaseYear(), album.getAlbumGenre(), album.getAlbumLabel(), album.getAlbumPrice(), album.getAlbumStock());
        viewModel.addAlbum(newAlbum);

        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    private static final Set<String> VALID_GENRES = new HashSet<>(Arrays.asList(
            "BLUES", "CLASSICAL", "COUNTRY", "DISCO", "EDM", "ELECTRONIC", "FUNK",
            "HEAVY_METAL", "HIP_HOP", "HOUSE", "INDIE", "JAZZ", "LO_FI", "PHONK",
            "POP", "PUNK", "RAP", "REGGAETON", "ROCK", "R_AND_B", "SOUL"));

    private boolean isValidGenre(String genre) {
        return VALID_GENRES.contains(genre.toUpperCase());
    }

    public void onCancelButtonClick(View view) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }




}
