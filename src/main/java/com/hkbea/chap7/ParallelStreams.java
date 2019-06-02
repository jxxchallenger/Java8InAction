package com.hkbea.chap7;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    
    public static long iterativeSum(long n) {
        long sum = 0;
        for(long i = 1; i <= n; i ++) {
            sum += i;
        }
        return sum;
    }
    
    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
    }
    
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
    }
    
    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1L, n).sum();
    }
    
    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1L, n).parallel().sum();
    }
    
    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static class Accumulator {
        private long total = 0;

        public void add(long value) {
            total += value;
        }
    }
}
