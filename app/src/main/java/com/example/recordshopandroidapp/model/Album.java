package com.example.recordshopandroidapp.model;


import com.google.gson.annotations.SerializedName;

public class Album {

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


    public Album(){}

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

    public Long getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Long albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumArtist() {
        return albumArtist;
    }

    public void setAlbumArtist(String albumArtist) {
        this.albumArtist = albumArtist;
    }

    public String getAlbumReleaseYear() {
        return albumReleaseYear;
    }

    public void setAlbumReleaseYear(String albumReleaseYear) {
        this.albumReleaseYear = albumReleaseYear;
    }

    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String albumGenre) {
        this.albumGenre = albumGenre;
    }

    public String getAlbumLabel() {
        return albumLabel;
    }

    public void setAlbumLabel(String albumLabel) {
        this.albumLabel = albumLabel;
    }

    public double getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(double albumPrice) {
        this.albumPrice = albumPrice;
    }

    public int getAlbumStock() {
        return albumStock;
    }

    public void setAlbumStock(int albumStock) {
        this.albumStock = albumStock;
    }


}
