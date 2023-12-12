package ru.netology.poster;

public class PosterManager {
    private CinemaObject[] poster = new CinemaObject[0];
    private int limit;
    public PosterManager() {
        limit = 5;
    }
    public PosterManager(int limit) {
        this.limit = limit;
    }
    public void add(CinemaObject movie) {
        CinemaObject[] tmp = new CinemaObject[poster.length + 1];
        for (int i = 0; i < poster.length; i++) {
            tmp[i] = poster[i];
        }
        tmp[tmp.length - 1] = movie;
        poster = tmp;
    }
    public CinemaObject[] findAll() {
        return poster;
    }
    public CinemaObject[] findLast() {
        int resultLength;
        if (poster.length < limit) {
            resultLength = poster.length;
        } else {
            resultLength = limit;
        }
        CinemaObject[] reversed = new CinemaObject[resultLength];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = poster[poster.length - 1 - i];
        }
        return reversed;
    }
}
