package com.mechannibalism.bluerayrentalshop.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private String movieId;
    private String title;
    private String director;
    private String genre;

    // Конструктор
    public Movie(String title, String director, String genre) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.movieId = movieId;
    }

    public Movie(@JsonProperty("movieId") String movieId,
        @JsonProperty("title") String title,
        @JsonProperty("director") String director,
        @JsonProperty("genre") String genre) {  // Додайте параметр "жанр"
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.genre = genre;  // Ініціалізація поля "жанр"
    }

    // Геттери та сеттери
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

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.genre = movieId;
    }


}
