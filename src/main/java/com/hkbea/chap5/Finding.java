package com.hkbea.chap5;

import java.util.Arrays;
import java.util.List;

import com.hkbea.chap4.Dish;

public class Finding {

    public static void main(String[] args) {
        if(isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }
        
        System.out.println(isHealthyMenu());
        
        System.out.println(isHealthyMenu2());
        
        // 5.3.3
        Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(System.out::println);
        
        // 5.3.4
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map(x -> x * x).filter(i -> i % 3 == 0).findFirst().ifPresent(System.out::println);
    }

    // 5.3.1
    private static boolean isVegetarianFriendlyMenu() {
        return Dish.menu.stream().anyMatch(Dish::isVegetarian);
    }
    
    // 5.3.2
    private static boolean isHealthyMenu() {
        return Dish.menu.stream().allMatch(dish -> dish.getCalories() < 1000);
    }
    
    // 5.3.2
    private static boolean isHealthyMenu2() {
        return Dish.menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);
    }
}
