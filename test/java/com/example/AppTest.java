package com.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testHighRatedAnime() {
        Anime anime = new Serial("Serial1", List.of("Action", "Fantasy"), 8.5, 24, LocalDate.of(2023, 1, 10));
        assertTrue(anime.getRating() > 7, "Аниме должно иметь рейтинг больше 7");
    }

    @Test
    public void testRecentRelease() {
        Anime anime = new ONA("ONA1", List.of("Action", "Sci-Fi"), 8.0, 12, LocalDate.of(2023, 5, 20));
        assertTrue(anime.getReleaseDate().isAfter(LocalDate.of(2022, 12, 31)),
                "Дата выхода должна быть 2023 или позже");
    }

    @Test
    public void testMostCommonGenres() {
        List<Anime> animes = List.of(
                new Serial("Serial1", List.of("Action", "Fantasy"), 8.5, 24, LocalDate.of(2023, 1, 10)),
                new ONA("ONA1", List.of("Action", "Sci-Fi"), 8.0, 12, LocalDate.of(2023, 5, 20)),
                new OVA("OVA1", List.of("Action", "Comedy"), 8.7, 3, LocalDate.of(2024, 1, 1)));

        long actionCount = animes.stream()
                .flatMap(anime -> anime.getGenres().stream())
                .filter(genre -> genre.equals("Action"))
                .count();

        assertEquals(3, actionCount, "Жанр 'Action' должен встречаться 3 раза");
    }
}
