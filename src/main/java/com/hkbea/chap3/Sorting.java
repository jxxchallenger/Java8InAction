package com.hkbea.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sorting {

	public static void main(String[] args) {
		List<String> strs = Arrays.asList("Hello", "hello", "world", "World");
		strs.sort(String::compareToIgnoreCase);
		System.out.println(strs);
		//3.6.1
		
		List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));
        
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        
        inventory.sort(Comparator.comparing((a) -> a.getWeight()));
        inventory.sort(Comparator.comparing(Apple::getWeight));
	}

}
