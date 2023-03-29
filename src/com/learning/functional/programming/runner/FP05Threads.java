package com.learning.functional.programming.runner;

import java.util.stream.IntStream;

public class FP05Threads {

    public static void main(String[] args) {

        /*Structural*/
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<10000; i++){
                    System.out.println(Thread.currentThread().getId() + " : " + i);
                }
            }
        };

//        Thread thread1 = new Thread(runnable1);
//        thread1.start();
//
//        Thread thread2 = new Thread(runnable1);
//        thread2.start();
//
//        Thread thread3 = new Thread(runnable1);
//        thread3.start();

        /*Functional*/
        Runnable runnable2 = () -> {
            IntStream.range(0,100).forEach(i -> System.out.println(Thread.currentThread().getId() + " : " + i));
        };

        Thread thread4 = new Thread(runnable2);
        thread4.start();

        Thread thread5 = new Thread(runnable2);
        thread5.start();

        Thread thread6 = new Thread(runnable2);
        thread6.start();
    }
}
