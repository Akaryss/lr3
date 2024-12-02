package com.example;

import java.time.LocalDate;
import java.util.List;

class ONA extends Anime { // Убрали public
    public ONA(String title, List<String> genres, double rating, int episodes, LocalDate releaseDate) {
        super(title, genres, rating, episodes, releaseDate);
    }

    public String getSpecialFeatures() {
        return "Содержит короткие серии, подходящие для быстрого просмотра.";
    }
}
