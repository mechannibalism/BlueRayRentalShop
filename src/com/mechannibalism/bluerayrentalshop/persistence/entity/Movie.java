package com.mechannibalism.bluerayrentalshop.persistence.entity;


import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("movieId")
    private String movieId;

    @SerializedName("title")
    private String title;

    @SerializedName("director")
    private String director;

    @SerializedName("genre")
    private String genre;

    // Конструктор за замовчуванням (обов'язковий для десеріалізації)
    public Movie() {
    }

    // Конструктор з параметрами
    public Movie(String movieId, String title, String director, String genre) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.genre = genre;
    }

    // Гетери та сетери для полів класу


    public String getMovieId() {
        return (movieId != null) ? movieId : "";
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


}
