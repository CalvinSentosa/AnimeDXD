package com.example.animedxd;

public class AnimeItem {
    private int imageResId, rating;
    private String title, description, genre;

    public AnimeItem(int imageResId, String title, int rating, String description, String genre) {
        this.imageResId = imageResId;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.genre = genre;
    }
    //
    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }
}

