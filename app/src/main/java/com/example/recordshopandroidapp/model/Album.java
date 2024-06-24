package com.example.recordshopandroidapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName("id")
    private Long albumID;
    @SerializedName("name")
    private String albumName;
    @SerializedName("artist")
    private String albumArtist;
    @SerializedName("releaseYear")
    private String albumReleaseYear;
    @SerializedName("genre")
    private String albumGenre;
    @SerializedName("label")
    private String albumLabel;
    @SerializedName("price")
    private double albumPrice;
    @SerializedName("stockQuantity")
    private int albumStock;


    public Album() {
    }

    public Album(Long albumID, String albumName, String albumArtist, String albumReleaseYear, String genre, String label, double price, int stockQuantity) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.albumArtist = albumArtist;
        this.albumReleaseYear = albumReleaseYear;
        this.albumGenre = genre;
        this.albumLabel = label;
        this.albumPrice = price;
        this.albumStock = stockQuantity;
    }

    @Bindable
    public Long getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Long albumID) {
        this.albumID = albumID;
    }

    @Bindable
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.albumName);
    }

    @Bindable
    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
        notifyPropertyChanged(BR.albumArtist);
    }

    @Bindable
    public String getAlbumReleaseYear() {
        return albumReleaseYear;
    }

    public void setAlbumReleaseYear(String albumReleaseYear) {
        this.albumReleaseYear = albumReleaseYear;
        notifyPropertyChanged(BR.albumReleaseYear);
    }

    @Bindable
    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String albumGenre) {
        this.albumGenre = albumGenre.toUpperCase();
        notifyPropertyChanged(BR.albumGenre);
    }

    @Bindable
    public String getAlbumLabel() {
        return albumLabel;
    }

    public void setAlbumLabel(String albumLabel) {
        this.albumLabel = albumLabel;
        notifyPropertyChanged(BR.albumLabel);
    }

    @Bindable
    public double getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(double albumPrice) {
        this.albumPrice = albumPrice;
        notifyPropertyChanged(BR.albumPrice);
    }

    @Bindable
    public int getAlbumStock() {
        return albumStock;
    }

    public void setAlbumStock(int albumStock) {
        this.albumStock = albumStock;
        notifyPropertyChanged(BR.albumStock);
    }


}
