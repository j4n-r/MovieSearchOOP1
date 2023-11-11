package com.j4n_r;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class APIsearch {
    private String movieSearch;
    private String httpResponse;

    // Constructor
    public APIsearch(String movieSearch) {
        this.movieSearch = movieSearch;
    }

    // replace spaces with "+" for the URL parameter
    private String cleanMovieSearch(String search) {
        return search.replace(" ", "+");
    }


    public List<Movie> apiSearchRequest(String search) {
        // init new HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            // send request to http://www.omdbapi.com/?s={movies+to+search}&apikey=fb437976
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://www.omdbapi.com/?s=" + cleanMovieSearch(search) + "&apikey=fb437976"))
                    .GET()
                    .build();
            // save response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // get response status code and print out response
            httpResponse = response.body();
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + httpResponse);

            // send httpResponse to Json parser
            return parseJsonResponse(httpResponse);

        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public List<Movie> apiSearch() {
        HttpClient httpClient = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://www.omdbapi.com/?s="  + "&apikey=" + System.getenv("API_KEY")))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            httpResponse = response.body();
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + httpResponse);

            return parseJsonResponse(httpResponse);

        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }




    private List<Movie> parseJsonResponse(String jsonResponse) {
        // new array list with movie Objects
        List<Movie> movies = new ArrayList<>();

        // new Json Parser with gson lib
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonResponse).getAsJsonObject();

        // essentially just sets the JSON response as instance variables
        if (jsonObject.has("Search")) {
            JsonArray searchResults = jsonObject.getAsJsonArray("Search");

            for (int i = 0; i < searchResults.size(); i++) {
                JsonObject movieJson = searchResults.get(i).getAsJsonObject();

                String title = movieJson.get("Title").getAsString();
                String year = movieJson.get("Year").getAsString();
                String imdbID = movieJson.get("imdbID").getAsString();
                String type = movieJson.get("Type").getAsString();

                Movie movie = new Movie(title, year, imdbID, type);
                movies.add(movie);
            }
        }

        return movies;
    }

    public String getMovieSearch() {
        return movieSearch;
    }

    public void setMovieSearch(String movieSearch) {
        this.movieSearch = movieSearch;
    }

    public String getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(String httpResponse) {
        this.httpResponse = httpResponse;
    }
}
