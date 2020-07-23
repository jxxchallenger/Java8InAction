package io.jxxchallenger.chap6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import io.jxxchallenger.chap6.Dish.Type;

public class Grouping {

    enum CaloricLevel { DIET, NORMAL, FAT };
    
    public static void main(String[] args) {
        System.out.println("Dishes grouped by type: " + groupDishesByType());
        //System.out.println("Dish names grouped by type: " + groupDishNamesByType());
        //System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
        //System.out.println("Caloric dishes grouped by type: " + groupCaloricDishesByType());
        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
        System.out.println("Count dishes in groups: " + countDishesInGroups());
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals());
        System.out.println("Sum calories by type: " + sumCaloriesByType());
        System.out.println("Caloric levels by type: " + caloricLevelsByType());
    }

    // 6.3
    private static Map<Type, List<Dish>> groupDishesByType() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType));
    }
    
    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return Dish.menu.stream().collect(Collectors.groupingBy(dish -> {
            if(dish.getCalories() <= 400)
            {
                return CaloricLevel.DIET;
            }
            else if(dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            }
            else {
                return CaloricLevel.FAT;
            }
        }));
    }
    
    // 6.3.1
    private static Map<Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
            if(dish.getCalories() <= 400)
            {
                return CaloricLevel.DIET;
            }
            else if(dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            }
            else {
                return CaloricLevel.FAT;
            }
        })));
    }
    
    // 6.3.2
    private static Map<Type, Long> countDishesInGroups() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
    }
    
    private static Map<Type, Optional<Dish>> mostCaloricDishesByType() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))));
    }
    
    private static Map<Type, Dish> mostCaloricDishesByTypeWithoutOprionals() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
    }
    
    private static Map<Type, Integer> sumCaloriesByType() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
    }
    
    private static Map<Type, Set<CaloricLevel>> caloricLevelsByType() {
        return Dish.menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
            if(dish.getCalories() <= 400)
            {
                return CaloricLevel.DIET;
            }
            else if(dish.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            }
            else {
                return CaloricLevel.FAT;
            }
        }, Collectors.toSet())));
    }
}
