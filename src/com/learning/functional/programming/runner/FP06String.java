package com.learning.functional.programming.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP06String {

    public static void main(String[] args){
        List<String> courses1 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        List<String> courses2 = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses1.stream().collect(Collectors.joining(" "));
        /*"Spring Spring Boot API Microservices AWS PCF Azure Docker Kubernetes"*/

        courses1.stream().collect(Collectors.joining(", "));
        /*"Spring, Spring Boot, API, Microservices, AWS, PCF, Azure, Docker, Kubernetes"*/

        /**
         * Flat Map allows you to flatten array of objects
         * Stream of String Arrays to Stream of Strings
         */
        courses1.stream().map(course -> course.split("")).flatMap(Arrays::stream).map(str -> str.toLowerCase()).filter(character -> character!=" ").distinct().collect(Collectors.toList());
        /*[s, p, r, i, n, g,  , b, o, t, a, m, c, e, v, w, f, z, u, d, k]*/

        courses1.stream()
                .flatMap(course1 ->
                        courses2.stream().filter(course2 -> course2.length()==course1.length())
                                .map(course2 -> List.of(course1, course2)))
                .filter(list -> !list.get(0).equalsIgnoreCase(list.get(1)))
                .collect(Collectors.toList());
        /*[[Spring, Docker], [API, AWS], [API, PCF], [AWS, API], [AWS, PCF], [PCF, API], [PCF, AWS], [Docker, Spring]]*/

        List<String> course3 = new ArrayList<>(courses1);
        course3.replaceAll(String::toUpperCase);
        course3.stream().collect(Collectors.toList());
        /*[SPRING, SPRING BOOT, API, MICROSERVICES, AWS, PCF, AZURE, DOCKER, KUBERNETES]*/

        course3.removeIf(str -> str.length()>6);
        course3.stream().collect(Collectors.toList());
        /*[SPRING, API, AWS, PCF, AZURE, DOCKER]*/
    }

}
