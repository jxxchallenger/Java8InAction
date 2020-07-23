package io.jxxchallenger.chap5;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.jxxchallenger.chap4.Dish;

public class NumericStreams {

    public static void main(String[] args) {
        
        int calories = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("Number of calories:" + calories);
        
        OptionalInt maxCalories = Dish.menu.stream().mapToInt(Dish::getCalories).max();
        maxCalories.ifPresent(System.out::println);
        System.out.println(IntStream.rangeClosed(1, 100).filter(i -> i % 2 == 0).count());
        
        Stream<double[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed().flatMap(a -> IntStream.rangeClosed(a, 100).mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)}).filter(t -> t[2] % 1 == 0));
        
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])); 
    }

}
