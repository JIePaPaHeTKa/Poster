package ru.netology.poster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    CinemaObject movie1 = new CinemaObject("Бладшот", "боевик");
    CinemaObject movie2 = new CinemaObject("Вперёд", "мультфильм");
    CinemaObject movie3 = new CinemaObject("Отель Белград", "комедия");
    CinemaObject movie4 = new CinemaObject("Джентльмены", "боевик");
    CinemaObject movie5 = new CinemaObject("Человек-невидимка", "ужасы");
    CinemaObject movie6 = new CinemaObject("Номер один", "комедия");

    @Test
    public void shouldAdd() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        CinemaObject[] expected = {movie1, movie2, movie3, movie4, movie5, movie6};
        CinemaObject[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfDefaultLimit() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        CinemaObject[] expected = {movie5, movie4, movie3, movie2, movie1};
        CinemaObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfOverLimit() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        CinemaObject[] expected = {movie6, movie5, movie4, movie3, movie2};
        CinemaObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfBelowLimit() {
        PosterManager manager = new PosterManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        CinemaObject[] expected = {movie3, movie2, movie1};
        CinemaObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindLastIfSetLimit() {
        PosterManager manager = new PosterManager(4);
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        CinemaObject[] expected = {movie6, movie5, movie4, movie3};
        CinemaObject[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
