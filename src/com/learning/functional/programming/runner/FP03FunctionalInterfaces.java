package com.learning.functional.programming.runner;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces {

    /**
     * Method to execute the main funtion
     *
     * @param args
     */
    public static void main(String[] args){

        List<Integer> numbers = List.of(3,45,6,23,15,3,76,15,13,87);
        functionalInterfaceExamples(numbers);
    }

    /**
     * Method to for funtional interface examples
     *
     * @param numbers
     */
    private static void functionalInterfaceExamples(List<Integer> numbers) {

        /*Predicate*/
        Predicate<Integer> isEvenPredicate02 = getPredicate();
        /*Function*/
        Function<Integer, Integer> squaredFunction02 = getFunction();
        /*Consumer*/
        Consumer<Integer> sysoutConsumer02 = getConsumer();
        System.out.println("Printing squares of all even numbers in list using functional programming : ");
        numbers.stream().filter(isEvenPredicate02).map(squaredFunction02).forEach(sysoutConsumer02);

        /*BinaryOperator*/
        BinaryOperator<Integer> sumBinaryOperator02 = getBinaryOperator();
        Integer sum1 = numbers.stream().reduce(0, sumBinaryOperator02);
        System.out.println("Printing sum of all numbers in list using functional programming : "+sum1);

        /*Supplier*/
        Supplier<Integer> supplier = getSupplier();
        System.out.println("Printing random number using supplier from functional programming : "+supplier.get());

        /*UnaryOperator*/
        UnaryOperator<Integer> unaryOperator = getUnaryOperator();
        System.out.println("Printing triple of a number using unary operator from functional programming : "+unaryOperator.apply(10));

        /*BiPredicate*/
        BiPredicate<Integer, String> biPredicate = getBiPredicate();
        System.out.println("Printing filtered value using BiPredicate from functional programming : "+biPredicate.test(11, "biPredicate"));

        /*BiFunction*/
        BiFunction<Integer, Double, String> biFunction = getBiFunction();
        System.out.println("Printing function value using BiFunction from functional programming : "+biFunction.apply(11, 12.0));

        /*BiConsumer*/
        BiConsumer<Integer, String> biConsumer = getBiConsumer();
        biConsumer.accept(10, "biConsumer");
    }

    /**
     * BiFunction works similar to consumer but accepts two different data type inputs and returns nothing
     *
     * @return
     */
    private static BiConsumer<Integer, String> getBiConsumer() {
        return (number, str) -> {
            System.out.println("Printing consumer values using BiConsumer from functional programming : " + number + " " + str);
        };
    }

    /**
     * BiFunction works similar to function but accepts two different data type inputs and returns a different data type value
     *
     * @return
     */
    private static BiFunction<Integer, Double, String> getBiFunction() {
        return (intNumber, doubleNumber) -> {
            return intNumber + " " + doubleNumber;
        };
    }

    /**
     * BiPredicate works similar to predicate but accepts two inputs with different data tyopes and returns a boolean value
     *
     * @return
     */
    private static BiPredicate<Integer, String> getBiPredicate() {
        return (number, str) -> {
            return number > 10 && str.length() > 5;
        };
    }

    /**
     * Unary Operator accepts one input and return a value of same data type
     *
     * @return
     */
    private static UnaryOperator<Integer> getUnaryOperator() {
        return (number) -> 3 * number;
    }

    /**
     * Supplier accepts no inputs and return a value
     *
     * @return
     */
    private static Supplier<Integer> getSupplier() {
        Supplier<Integer> supplier = () -> {
            Random random = new Random();
            return random.nextInt(10);
        };
        return supplier;
    }

    /**
     * Binary Operator accepts two inputs with same data type and performs operation on it and return same data type back
     *
     * @return
     */
    private static BinaryOperator<Integer> getBinaryOperator() {
        BinaryOperator<Integer> sumBinaryOperator01 = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator02 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x+y;
            }
        };
        return sumBinaryOperator02;
    }

    /**
     * Consumer accepts single input and performs operation on it and return no object value back
     *
     * @return
     */
    private static Consumer<Integer> getConsumer() {
        Consumer<Integer> sysOutConsumer01 = System.out::println;
        Consumer<Integer> sysoutConsumer02 = new Consumer<Integer>(){
            @Override
            public void accept(Integer x){
                System.out.println(x);
            }
        };
        return sysoutConsumer02;
    }

    /**
     * Function accepts single input it evaluates and return object value
     *
     * @return
     */
    private static Function<Integer, Integer> getFunction() {
        Function<Integer, Integer> squaredFunction01 = x -> x * x;
        Function<Integer, Integer> squaredFunction02 = new Function<Integer, Integer>(){
            @Override
            public Integer apply(Integer x){
                return x*x;
            }
        };
        return squaredFunction02;
    }

    /**
     * Predicate accepts single input it evaluates and return boolean value
     *
     * @return
     */
    private static Predicate<Integer> getPredicate() {
        Predicate<Integer> isEvenPredicate01 = x -> x % 2 == 1;
        Predicate<Integer> isEvenPredicate02 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x){
                return x%2==0;
            }
        };
        return isEvenPredicate02;
    }
}
