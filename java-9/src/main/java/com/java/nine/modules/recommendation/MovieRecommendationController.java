package com.java.nine.modules.recommendation;

import java.util.List;

public class MovieRecommendationController {

    public List<String> recommendMovies() {
        Module module = MovieRecommendationController.class.getModule();
        System.out.println("Module: " + module);
        System.out.println("Module name: " + module.getName());

        return List.of("Bad Boys", "The Departed", "Django Unchained");
    }
}
