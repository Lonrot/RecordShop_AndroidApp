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
}
