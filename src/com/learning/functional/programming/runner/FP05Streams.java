package com.learning.functional.programming.runner;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FP05Streams {

    public static void main(String[] args){

        /*Create a Stream from a list (Wrapper classes) */
        List<? extends Serializable> listData = List.of(15, 12, 45, 26, 67);
        listData.stream().forEach(System.out::println);

        /*Create a Stream (Wrapper classes) */
        Stream<Integer> integerStreamData = Stream.of(15, 12, 45, 26, 67);
        integerStreamData.forEach(System.out::println);

        /*Create a Stream for an Array (primitive type) */
        int[] arrayData = {15, 12, 45, 26, 67};
        IntStream arrayStreamData = Arrays.stream(arrayData);
        int sumValue = arrayStreamData.sum();
        OptionalInt maxValue = Arrays.stream(arrayData).max();
        OptionalInt minValue = Arrays.stream(arrayData).min();
        System.out.println("Printing sum, max and min values from a array stream : \nsum: "+sumValue +
                "\nmax: "+maxValue.getAsInt() + "\nmin: "+minValue.getAsInt());

        /*Create a Stream with a specific algorithm*/
        IntStream intStream1 = IntStream.range(1,10);
        int sumValue1 = intStream1.sum(); //45

        IntStream intStream2 = IntStream.rangeClosed(1,10);
        int sumValue2 = intStream2.sum(); //55

        /**
         * Iterate allows you to have your own logic
         * limit is required or else it will become an infinite iteration
         * Peak is used to look into stream without making any changes
         */
        IntStream.iterate(1, number -> number + 2).peek(System.out::println).limit(10).sum();
        /*RESULT:
        1
        3
        5
        7
        9
        11
        13
        15
        17
        19
        $4 ==> 100*/

        /**
         * Converting into a list but it fails since it is a primitive type data set
         * so doing a boxing will allow us to do it
         */
        IntStream.iterate(2, e -> e * 2).limit(10).boxed().collect(Collectors.toList());
        /*[2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]*/

        /**
         * This kind of values cannot be handled by Long or Integer
         * so, we'll have to map to a BigInteger when it comes to big values
         */
        IntStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
        /*30414093201713378043612608166064768844377641568960512000000000000*/

    }

}
