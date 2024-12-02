package com.example;

import java.time.LocalDate;
import java.util.List;

class Serial extends Anime { // Убрали public
    public Serial(String title, List<String> genres, double rating, int episodes, LocalDate releaseDate) {
        super(title, genres, rating, episodes, releaseDate);
    }

    public String getSpecialFeatures() {
        return "Длинные серии с детальным раскрытием сюжета и персонажей.";
    }
}
