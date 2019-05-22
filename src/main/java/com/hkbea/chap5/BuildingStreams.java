package com.hkbea.chap5;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {

    public static void main(String[] args) {
        // 5.7.1
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        
        // 5.7.2
        int[] numbers = {2, 3, 5, 7, 11, 13};
        
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // 5.7.4
        Stream.iterate(0, n -> n + 2).limit(100).forEach(System.out::println);
        
        Stream.iterate(new int[] {0, 1}, a -> new int[] {a[1], a[0] + a[1]}).limit(20).forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
        
    }

}
