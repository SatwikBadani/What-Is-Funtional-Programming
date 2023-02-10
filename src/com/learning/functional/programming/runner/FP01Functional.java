package com.learning.functional.programming.runner;

import java.util.List;

/**
 * Class for FP01 functional way
 */
public class FP01Functional {

    /**
     * Method to execute the main funtion
     *
     * @param args
     */
    public static void main(String[] args){
        List<Integer> numbers = List.of(5,32,13,74,55,46);
        printAllNumbersInList01(numbers);
        printAllNumbersInList02(numbers);
        printAllEvenNumbersInList(numbers);
        printAllOddNumbersInList(numbers);
        printAllSquaresOfNumbersInList(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printAllCoursesIndividually(courses);
        printAllCoursesContainsSpring(courses);
        printAllCoursesContainsMin4Letters(courses);
        printLengthOfEachCourse(courses);

    }

    /**
     * Method to print length of each course from input list
     *
     * @param courses
     */
    private static void printLengthOfEachCourse(List<String> courses) {
        System.out.println("Printing length of each course in list using functional programming");
        courses.stream().map(course -> course + " " +course.length()).forEach(System.out::println);
    }

    /**
     * Method to print all squares of numbers from input list
     * 
     * @param numbers
     */
    private static void printAllSquaresOfNumbersInList(List<Integer> numbers){
        System.out.println("Printing all squares of numbers in list using functional programming");
        numbers.stream().map(FP01Functional::getSquareOfNumber).forEach(System.out::println);
    }

    /**
     * Method to return square of an input number
     * 
     * @param number
     * @return
     */
    private static double getSquareOfNumber(Integer number) {
        return Math.pow(number, 2);
    }

    /**
     * Method to print all courses contains atleast 4 letters
     *
     * @param courses
     */
    private static void printAllCoursesContainsMin4Letters(List<String> courses){
        System.out.println("Printing all courses contains atleast 4 letters in list using functional programming");
        courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
    }

    /**
     * Method to print all courses contains Spring from the input list
     *
     * @param courses
     */
    private static void printAllCoursesContainsSpring(List<String> courses){
        System.out.println("Printing all courses contains Spring in list using functional programming");
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    /**
     * Method to print all courses from the input list
     *
     * @param courses
     */
    private static void printAllCoursesIndividually(List<String> courses){
        System.out.println("Printing all courses in list using functional programming");
        courses.stream().forEach(System.out::println);
    }

    /**
     * Method to print all odd numbers from input list
     *
     * @param numbers
     */
    private static void printAllOddNumbersInList(List<Integer> numbers){
        System.out.println("Printing all odd numbers in list using functional programming");
        numbers.stream().filter(number -> number%2==1).forEach(System.out::println);
    }

    /**
     * Method to print all even numbers from input list
     *
     * @param numbers
     */
    private static void printAllEvenNumbersInList(List<Integer> numbers) {
        System.out.println("Printing all even numbers in list using functional programming");
        numbers.stream().filter(number -> number%2==0).forEach(System.out::println);
    }

    /**
     * Method to print all numbers from input list second way
     *
     * @param numbers
     */
    private static void printAllNumbersInList02(List<Integer> numbers) {
        System.out.println("Printing all numbers in list using functional programming in second way");
        numbers.stream().forEach(System.out::println);
    }

    /**
     * Method to print all numbers from input list first way
     *
     * @param numbers
     */
    private static void printAllNumbersInList01(List<Integer> numbers) {
        System.out.println("Printing all numbers in list using functional programming in first way");
        numbers.stream().forEach(FP01Functional::printInputIntegers);
    }

    /**
     * Method to print input numbers
     *
     * @param number
     */
    private static void printInputIntegers(Integer number) {
        System.out.println(number);
    }

}


