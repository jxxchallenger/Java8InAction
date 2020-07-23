package io.jxxchallenger.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {

    public static void main(String[] args) {
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(str -> System.out.println(str));

        System.out.println("----------------------------------------");
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);

        List<String> threeHighCaloricDishNames = Dish.menu.parallelStream().filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloricDishNames);
        // 4.4

        List<String> names = Dish.menu.stream().filter(d -> {
            System.out.println("filtering " + d.getName());
            return d.getCalories() > 300;
        }).map(d -> {
            System.out.println("mapping " + d.getName());
            return d.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println(names);
    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, Comparator.comparing(Dish::getCalories));

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        return dishes.parallelStream().filter((Dish dish) -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories)).map(dish -> dish.getName())
                .collect(Collectors.toList());
    }

}
