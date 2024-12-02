package com.example;

import java.time.LocalDate;
import java.util.List;

abstract class Anime { // Убрали public
    private String title;
    private List<String> genres;
    private double rating;
    private int episodes;
    private LocalDate releaseDate;

    public Anime(String title, List<String> genres, double rating, int episodes, LocalDate releaseDate) {
        this.title = title;
        this.genres = genres;
        this.rating = rating;
        this.episodes = episodes;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    public int getEpisodes() {
        return episodes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                ", rating=" + rating +
                ", episodes=" + episodes +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
