package com.learning.functional.programming.runner;

import java.util.stream.LongStream;

public class FP06Parallelizing {

    public static void main(String[] args) {

        long time1 = System.currentTimeMillis();
        long sum1 = LongStream.range(0, 1000000000).sum();
        long timeDifference1 = System.currentTimeMillis() - time1;
        System.out.println("Sum calculated: " + sum1 + "\nTime Taken: " + timeDifference1);

        long time2 = System.currentTimeMillis();
        long sum2 = LongStream.range(0, 1000000000).parallel().sum();
        long timeDifference2 = System.currentTimeMillis() - time2;
        System.out.println("Sum calculated parallel: " + sum2 + "\nTime Taken: " + timeDifference2);

        /*Sum calculated: 499999999500000000
        Time Taken: 2136 ms
        Sum calculated parallel: 499999999500000000
        Time Taken: 187 ms*/
    }
}
