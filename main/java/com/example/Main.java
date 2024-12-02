package com.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main { // Единственный публичный класс
        public static void main(String[] args) {
                List<Anime> animes = createSampleAnimes();
                displayHighRatedAnimes(animes);
                displayRecentAnimes(animes);
                displayTopGenres(animes);
        }

        private static List<Anime> createSampleAnimes() {
                return Arrays.asList(
                                new Serial("Сериал1", List.of("Экшен", "Фэнтези"), 8.5, 24, LocalDate.of(2023, 1, 10)),
                                new Serial("Сериал2", List.of("Драма", "Романтика"), 7.8, 50,
                                                LocalDate.of(2022, 4, 15)),
                                new ONA("ONA1", List.of("Экшен", "Научная фантастика"), 8.0, 12,
                                                LocalDate.of(2023, 5, 20)),
                                new ONA("ONA2", List.of("Фэнтези"), 7.0, 10, LocalDate.of(2021, 3, 10)),
                                new OVA("OVA1", List.of("Комедия", "Экшен"), 8.7, 3, LocalDate.of(2024, 1, 1)),
                                new OVA("OVA2", List.of("Драма"), 6.9, 2, LocalDate.of(2020, 7, 10)),
                                new Serial("Сериал3", List.of("Хоррор", "Триллер"), 9.0, 10,
                                                LocalDate.of(2024, 10, 15)),
                                new ONA("ONA3", List.of("Экшен", "Комедия"), 8.3, 15, LocalDate.of(2023, 8, 8)),
                                new OVA("OVA3", List.of("Романтика"), 7.5, 4, LocalDate.of(2023, 6, 12)),
                                new Serial("Сериал4", List.of("Научная фантастика", "Драма"), 9.1, 26,
                                                LocalDate.of(2023, 12, 20)));
        }

        private static void displayHighRatedAnimes(List<Anime> animes) {
                System.out.println(" Аниме с рейтингом выше 7:");
                animes.stream()
                                .filter(anime -> anime.getRating() > 7)
                                .forEach(anime -> System.out.printf("Название: %s | Рейтинг: %.1f%n", anime.getTitle(),
                                                anime.getRating()));
        }

        private static void displayRecentAnimes(List<Anime> animes) {
                System.out.println("\n Аниме, вышедшие недавно (2023 и позже):");
                animes.stream()
                                .filter(anime -> anime.getReleaseDate().isAfter(LocalDate.of(2022, 12, 31)))
                                .forEach(anime -> System.out.printf("Название: %s | Дата выхода: %s%n",
                                                anime.getTitle(), anime.getReleaseDate()));
        }

        private static void displayTopGenres(List<Anime> animes) {
                System.out.println("\n Топ-3 часто встречающихся жанра:");
                animes.stream()
                                .flatMap(anime -> anime.getGenres().stream())
                                .collect(Collectors.groupingBy(genre -> genre, Collectors.counting()))
                                .entrySet().stream()
                                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                                .limit(3)
                                .forEach(entry -> System.out.printf("Жанр: %s | Количество: %d%n", entry.getKey(),
                                                entry.getValue()));
        }
}
