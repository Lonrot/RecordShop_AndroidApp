package com.example.recordshopandroidapp;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recordshopandroidapp.databinding.AlbumLayoutBinding;
import com.example.recordshopandroidapp.model.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;


public class AlbumAdapter  extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<Album> albumList;
    private Context context;

    public AlbumAdapter(List<Album> albums, Context context) {
        this.albumList = albums;
        this.context = context;

    }


    @NotNull @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout,parent,false);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder holder, int position) {
        //Get the item at the current position
        Album album = albumList.get(position);

        //Bind data to the ViewHolder
        holder.imageView.setImageResource(Resources.ID_NULL);
        holder.albumNameView.setText(album.getAlbumName());
        holder.artistNameView.setText(album.getAlbumArtist());
        holder.albumPriceView.setText(String.valueOf(album.getAlbumPrice()));
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
    private AlbumLayoutBinding albumLayoutBinding;
    ImageView imageView;
    TextView albumNameView;
    TextView artistNameView;
    TextView albumPriceView;


    public AlbumViewHolder(@NotNull View albumView){
        super(albumView);
        this.imageView = albumView.findViewById(R.id.albumImageView);
        this.albumNameView = albumView.findViewById(R.id.albumNameTextView);
        this.artistNameView = albumView.findViewById(R.id.artistAlbumView);
        this.albumPriceView = albumView.findViewById(R.id.albumTextViewPrice);
    }

    }


}
