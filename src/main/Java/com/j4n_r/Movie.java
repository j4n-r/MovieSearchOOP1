package com.j4n_r;

public class Movie {
    private String title;
    private String year;
    private String imdbID;
    private String type;

    private String directors;
    private String genre;
    private String plot;
    private String imdbRating;


    public Movie(String title, String year, String imdbID, String type) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
    }

    public Movie(String title, String year, String imdbID, String type, String directors, String genre, String plot, String imdbRating) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
        this.type = type;
        this.directors = directors;
        this.genre = genre;
        this.plot = plot;
        this.imdbRating = imdbRating;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

}
