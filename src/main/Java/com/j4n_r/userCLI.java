package com.j4n_r;

import java.util.List;
import java.util.Scanner;

public class userCLI {

    public static void getNewSearch() {
        // get user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nach welchem Titel wollen sie suchen?");
        // new APIsearch
        APIsearch apiSearch = new APIsearch(scanner.nextLine());
        // -> input is now this.movieSearch

        // make the actual request  with this.movieSearch as a parameter
        List<Movie> movies = apiSearch.apiSearchRequest(apiSearch.getMovieSearch());

        // loop through array and print it out
        for (Movie movie : movies) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Year: " + movie.getYear());
            System.out.println("IMDb ID: " + movie.getImdbID());
            System.out.println("Type: " + movie.getType());
            System.out.println("-----------");
        }
    }
}