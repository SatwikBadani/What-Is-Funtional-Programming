package com.learning.functional.programming.runner;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for FP01 structured way
 *
 * @Satwik
 */
public class FP01Structured {

    public static void main(String[] args){
        List<Integer> numbers = new ArrayList<>();
        numbers = List.of(5,32,13,74,55,46);
        printAllNumbersInList(numbers);
        printAllEvenNumbersInList(numbers);
    }

    private static void printAllEvenNumbersInList(List<Integer> numbers) {
        System.out.println("Printing all even numbers in list using structured programming: ");
        for(int number: numbers){
            if(number%2==0){
                System.out.println(number);
            }
        }
    }

    private static void printAllNumbersInList(List<Integer> numbers) {
        System.out.println("Printing all numbers in list using structured programming: ");
        for(int number: numbers){
            System.out.println(number);
        }
    }

}


