package com.mechannibalism.bluerayrentalshop.persistence;

public class Movie {

    private String title;
    private String director;
    private int releaseDate;
    private String genre;

    // Конструктор
    public Movie(String title, String director, int releaseDate, String genre) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
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

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Інші методи та функції, які можуть знадобитися...
}
