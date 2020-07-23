package io.jxxchallenger.chap5;

import java.util.Arrays;
import java.util.List;

public class Reducing {

    public static void main(String[] args) {
        // 5.4.1
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        
        numbers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        
        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
        
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println);

    }
    

}
