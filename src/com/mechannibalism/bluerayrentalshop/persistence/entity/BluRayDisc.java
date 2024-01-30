package com.mechannibalism.bluerayrentalshop.persistence.entity;

import com.google.gson.annotations.SerializedName;

public class BluRayDisc {

    @SerializedName("id")
    private int discId;

    @SerializedName("title")
    private String movieTitle;

    @SerializedName("director")
    private String director;

    @SerializedName("availableForRent")
    private boolean availableForRent;

    public BluRayDisc(int discId, String movieTitle, String director, boolean availableForRent) {
        this.discId = discId;
        this.movieTitle = movieTitle;
        this.director = director;
        this.availableForRent = availableForRent;
    }

    // Додайте гетери та сетери за необхідністю

    @Override
    public String toString() {
        return "BluRayDisc{" +
            "discId=" + discId +
            ", movieTitle='" + movieTitle + '\'' +
            ", director='" + director + '\'' +
            ", availableForRent=" + availableForRent +
            '}';
    }
    
}
