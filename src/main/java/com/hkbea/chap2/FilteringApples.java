package com.hkbea.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
		FilteringApples filteringApples = new FilteringApples();
		List<Apple> result = filteringApples.filterGreenApples(inventory);
		System.out.println(result);
		result = filteringApples.filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println(result);
		result = filteringApples.filterApples(inventory, new AppleHeavyWeightPredicate());
		System.out.println(result);
		
		result = filteringApples.filterApples(inventory, new ApplePredicate() {
			
			@Override
			public boolean test(Apple apple) {
				return "red".equalsIgnoreCase(apple.getColor());
			}
		});
		System.out.println(result);
	}
	
	public List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if("green".equalsIgnoreCase(apple.getColor())) {
				result.add(apple);
			}
		}
		return result;
	}
	
	public List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
		List<Apple> result = new ArrayList<Apple>();
		for(Apple apple : inventory) {
			if(predicate.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

}

class Apple {
	private int weight;
	
	private String color;

	public Apple(int weight, String color) {
		super();
		this.weight = weight;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + "]";
	}
	
}