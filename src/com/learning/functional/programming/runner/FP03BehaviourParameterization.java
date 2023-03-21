package com.learning.functional.programming.runner;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {

    /**
     * Method to execute the main funtion
     *
     * @param args
     */
    public static void main(String[] args){

        List<Integer> numbers = List.of(3,45,6,23,15,3,76,15,13,87);

        filterAndPrint(numbers, x -> x%2 ==0);
        filterAndPrint(numbers, x -> x%2 ==1);

        Function<Integer, Integer> squaredList = number -> number * number;
        printMappedValues(numbers, squaredList);

    }

    /**
     * Method to print mapped values
     *
     * @param numbers
     * @param squaredList
     */
    private static void printMappedValues(List<Integer> numbers, Function<Integer, Integer> squaredList) {
        System.out.println("Printing square of all numbers in list using functional programming : ");
        numbers.stream().map(squaredList).collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * Method to filter and print
     *
     * @param numbers
     * @param predicate
     */
    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        System.out.println("Printing filtered numbers in list using functional programming : ");
        numbers.stream().filter(predicate).forEach(System.out::println);
    }
}
