package com.mechannibalism.bluerayrentalshop.persistence.entity;

public class BluRayDisc {

    private String discId;
    private boolean isAvailable;
    private Movie movie;
    private String genre;

    // Конструктор
    public BluRayDisc(String discId, boolean isAvailable, Movie movie, String genre) {
        this.discId = discId;
        this.isAvailable = isAvailable;
        this.movie = movie;
        this.genre = genre;
    }

    // Геттери та сеттери
    public String getDiscId() {
        return discId;
    }

    public void setDiscId(String discId) {
        this.discId = discId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Метод для оренди диску
    public void rent(Customer customer) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Диск '" + movie.getTitle() + "' орендовано користувачем "
                + customer.getFullName());
        } else {
            System.out.println("Диск '" + movie.getTitle() + "' вже взятий в прокат.");
        }
    }

    // Метод для повернення диску
    public void returnDisc() {
        isAvailable = true;
    }
}
