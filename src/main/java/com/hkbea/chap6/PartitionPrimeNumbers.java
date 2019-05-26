package com.hkbea.chap6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionPrimeNumbers {

    public static void main(String[] args) {
        System.out.println("Numbers partitioned in prime and non-prime: " + partitionPrimes(100));

    }

    private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(i -> isPrime(i)));
    }
    
    private static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
    }
}
