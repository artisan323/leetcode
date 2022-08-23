package com.artiasn.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodRatings {

    private Map<String, List<Integer>> foodRatingMap = new HashMap<>();
    String[] foods;
    String[] cuisines;
    int[] ratings;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foods = foods;
        cuisines = cuisines;
        ratings = ratings;
    }

    public void changeRating(String food, int newRating) {

    }

    public String highestRated(String cuisine) {
        return "";
    }

}
