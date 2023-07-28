package com.java.nine.modules;

import com.java.nine.modules.recommendation.MovieRecommendationController;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello Modules...");
        MovieRecommendationController movieRecommendationController = new MovieRecommendationController();

        List<String> movies = movieRecommendationController.recommendMovies();
        System.out.println("Recommended movies: " + movies);
    }
}
