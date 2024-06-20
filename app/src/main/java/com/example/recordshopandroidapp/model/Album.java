package com.example.recordshopandroidapp.model;




public class Album {
    private Long id;
    private String name;
    private String artist;
    private String releaseYear;
    private String genre;
    private String label;
    private double price;
    private int stockQuantity;


    public Album(){}

    public Album(Long id ,String name, String artist, String releaseYear, String genre, String label, double price, int stockQuantity) {
        this.id=id;
        this.name = name;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.label = label;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
