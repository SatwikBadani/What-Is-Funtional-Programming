package com.learning.functional.programming.runner;

import java.beans.Expression;
import java.util.Comparator;
import java.util.List;

public class FP02Funtional {

    /**
     * Method to execute the main funtion
     *
     * @param args
     */
    public static void main(String[] args){
        List<Integer> numbers = List.of(3,45,6,23,15,3,76,15,13,87);
        printSumOfNumbersInList(numbers);
        printMaxValueOfNumbersInList(numbers);
        printMinValueOfNumbersInList(numbers);
        printSumOfSquaresOfNumbersInList(numbers);
        printSumOfCubessOfNumbersInList(numbers);
        printSumOfOddNumbersInList(numbers);
        printDistinctNumbersInList(numbers);
        printSortedNumbersInList(numbers);
        printSortedNumbersUsingComparatorInList(numbers);
    }

    /**
     * Method to print sorted numbers using comparator in a list
     *
     * @param numbers
     */
    private static void printSortedNumbersUsingComparatorInList(List<Integer> numbers){
        System.out.print("\nPrinting sorted numbers using comparator natural order in list using functional programming : ");
        numbers.stream().sorted(Comparator.naturalOrder()).forEach(number -> {
            System.out.printf("%d ",number);
        });
        System.out.print("\nPrinting sorted numbers using comparator reverse order in list using functional programming : ");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(number -> {
            System.out.printf("%d ",number);
        });
        System.out.print("\nPrinting sorted numbers using comparator custom in list using functional programming : ");
        numbers.stream().sorted(Comparator.comparing(number -> number.byteValue())).forEach(number -> {
            System.out.printf("%d ",number);
        });
    }

    /**
     * Method to print sorted numbers in a list
     *
     * @param numbers
     */
    private static void printSortedNumbersInList(List<Integer> numbers){
        System.out.print("\nPrinting sorted numbers in list using functional programming : ");
        numbers.stream().sorted().forEach(number -> {
            System.out.printf("%d ",number);
        });
    }

    /**
     * Method to print all the distinct numbers in a list
     *
     * @param numbers
     */
    private static void printDistinctNumbersInList(List<Integer> numbers){
        System.out.print("Printing distinct numbers in list using functional programming : ");
        numbers.stream().distinct().forEach(number -> {
            System.out.printf("%d ",number);
        });
    }

    /**
     * Method to print sum of odd numbers in a list
     *
     * @param numbers
     */
    private static void printSumOfOddNumbersInList(List<Integer> numbers){
        Integer sumOfOdds =  numbers.stream().filter(number -> number%2==1).reduce(0, (x,y) -> x + y);
        System.out.println("Printing sum of odd numbers in list using functional programming : "+sumOfOdds);
    }

    /**
     * Method to print sum of cubes of number in a list
     *
     * @param numbers
     */
    private static void printSumOfCubessOfNumbersInList(List<Integer> numbers){
        Integer sumOfCubes =  numbers.stream().map(number -> number * number * number).reduce(0, (x,y) -> x + y);
        System.out.println("Printing sum of cubes of all numbers in list using functional programming : "+sumOfCubes);
    }

    /**
     * Method to print sum of squares of number in a list
     *
     * @param numbers
     */
    private static void printSumOfSquaresOfNumbersInList(List<Integer> numbers){
        Integer sumOfSquares =  numbers.stream().map(number -> number * number).reduce(0, (x,y) -> x + y);
        System.out.println("Printing sum of squares of all numbers in list using functional programming : "+sumOfSquares);
    }

    /**
     * Method to print min value of number in a list
     *
     * @param numbers
     */
    private static void printMinValueOfNumbersInList(List<Integer> numbers){
        /*Using Lambda expression*/
        Integer min1 = numbers.stream().reduce(Integer.MAX_VALUE, (x, y) -> x > y ? y : x);
        /*Using Method reference*/
        Integer min2 = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("Printing min of all numbers in list using functional programming : "+min2   );
    }

    /**
     * Method to print max value of number in a list
     *
     * @param numbers
     */
    private static void printMaxValueOfNumbersInList(List<Integer> numbers){
        /*Using Lambda expression*/
        Integer max1 = numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
        /*Using Method reference*/
        Integer max2 = numbers.stream().reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("Printing max of all numbers in list using functional programming : "+max2);
    }

    /**
     * Method to print sum of numbers in a list
     *
     * @param numbers
     */
    private static void printSumOfNumbersInList(List<Integer> numbers){
        /*Using Method Reference*/
        Integer sum1 = numbers.stream().reduce(0, Integer::sum);
        /*Using Lambda Expression*/
        Integer sum2 = numbers.stream().reduce(0, (x,y) -> x + y);
        System.out.println("Printing sum of all numbers in list using functional programming : "+sum2);
    }

}
