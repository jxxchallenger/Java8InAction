package io.jxxchallenger.chap6;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Summarizing {

    public static void main(String[] args) {
        System.out.println("Nr. of dishes: " + howManyDishes());
        System.out.println("The most caloric dish is: " + findMostCaloricDish());
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Average calories in menu: " + calculateAverageCalories());
        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }

    // 6.2.1
    private static long howManyDishes() {
        
        return Dish.menu.stream().collect(Collectors.counting());
    }

    private static Dish findMostCaloricDish() {
        
        return Dish.menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).get();
    }
    
    // 6.2.2
    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));
    }
    
    private static double calculateAverageCalories() {
        return Dish.menu.stream().collect(Collectors.averagingInt(Dish::getCalories));
    }
    
    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
    }
    
    
    // 6.2.3
    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
    }
    
    private static String getShortMenuCommaSeparated() {
        return Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
    }
    
}
