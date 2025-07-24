package com.example.animedxd;

public class AnimeItem {
    private int imageResId;
    private String title;

    public AnimeItem(int imageResId, String title) {
        this.imageResId = imageResId;
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }
}

