package com.example;

import java.time.LocalDate;
import java.util.List;

class OVA extends Anime { // Убрали public
    public OVA(String title, List<String> genres, double rating, int episodes, LocalDate releaseDate) {
        super(title, genres, rating, episodes, releaseDate);
    }

    public String getSpecialFeatures() {
        return "Специальные серии, часто являющиеся дополнением к основному сюжету.";
    }
}
