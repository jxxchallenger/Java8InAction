package com.hkbea.chap5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.hkbea.chap4.Dish;

public class Mapping {

	public static void main(String[] args) {
		
		//5.2.1
		List<String> names = Dish.menu.stream().map(Dish::getName).collect(Collectors.toList());
		System.out.println(names);
		
		List<String> words = Arrays.asList("Java 8", "Lambdas", "In", "Action");
		
		List<Integer> wordLengths = words.stream().map(s -> s.length()).collect(Collectors.toList());
		System.out.println(wordLengths);
		
		//5.2.2
		System.out.println("=================================== 5.2.2 ===================================");
		List<String> uniqueCharacters = words.stream().map(s -> s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		System.out.println(uniqueCharacters);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squares = numbers.stream().map(n -> n*n).collect(Collectors.toList());
		squares.forEach(System.out::println);
		
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().filter(j -> (i +j) % 3 ==0).map(j -> new int[] {i, j})).collect(Collectors.toList());
		pairs.forEach(a -> {System.out.println(a[0] + " : " + a[1]);});
		
		
	}

}
