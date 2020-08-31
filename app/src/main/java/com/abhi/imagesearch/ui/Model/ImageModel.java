package com.abhi.imagesearch.ui.Model;

public class ImageModel {
    private String imageResourse;
    private String title;

    public ImageModel(String title, String imageResourse){
        this.title = title;
        this.imageResourse = imageResourse;
    }

    public String getImageResourse() {
        return imageResourse;
    }

    public String getTitle() {
        return title;
    }
}
