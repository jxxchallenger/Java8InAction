package com.hkbea.chap3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ExecuteAround {

	public static void main(String[] args) throws IOException {
		String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
		System.out.println(twoLines);

		List<String> sources = new ArrayList<String>();
		sources.add("");
		sources.add("");
		sources.add("hello");
		sources.add("world");

		List<String> result = filter(sources, (String str) -> !str.isEmpty());
		System.out.println(result);
		forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
		
		// ch 3.4.3
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/com/hkbea/chap3/data.txt"))) {
			return p.process(br);
		}
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}

	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T i : list) {
			c.accept(i);
		}

	}
}
