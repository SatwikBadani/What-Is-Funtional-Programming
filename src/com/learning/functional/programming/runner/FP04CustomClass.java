package com.learning.functional.programming.runner;

import com.learning.functional.programming.model.Course;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClass {

    public static void main(String[] args){

        List<Course> courses = List.of(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 91, 12000),
                new Course("API", "Microservices", 94, 18000),
                new Course("Microservices", "Microservices", 98, 22000),
                new Course("Full Stack", "Full Stack", 88, 21000),
                new Course("AWS", "Cloud", 92, 13000),
                new Course("Azure", "Cloud", 96, 16000),
                new Course("Docker", "Cloud", 87, 19000),
                new Course("Kubernetes", "Cloud", 81, 15000)
        );
        examplesForMatches(courses);
        examplesForSorting(courses);
        examplesForTakeDropWhile(courses);
        examplesForBasicOperations(courses);
        examplesForGroupingBy(courses);
    }

    /**
     * Method to write examples for grouping by
     *
     * @param courses
     */
    private static void examplesForGroupingBy(List<Course> courses) {
        Map<String, List<Course>> mappedData = courses.stream().collect(Collectors.groupingBy(Course::getCategory));
        System.out.println(mappedData);

        Map<String, Long> mappedDataWithCount = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
        System.out.println(mappedDataWithCount);

        Map<String, Optional<Course>> mappedDataWithMaxRating = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getRating))));
        System.out.println(mappedDataWithMaxRating);

        Map<String, List<String>> mappedDataWithCourseName = courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList())));
        System.out.println(mappedDataWithCourseName);
    }

    /**
     * Method to write examples for basic operations
     *
     * @param courses
     */
    private static void examplesForBasicOperations(List<Course> courses) {
        int totalNoOfStudentsMetCriteria =
                courses.stream().filter(course -> course.getRating() > 90).mapToInt(Course::getNoOfStudents).sum();
        System.out.println("\nPrinting the total no of students met criteria using sum from functional programming : "+totalNoOfStudentsMetCriteria);

        double averageOfStudentsMetCriteria =
                courses.stream().filter(course -> course.getRating() > 90).mapToInt(Course::getNoOfStudents).average().orElse(0.0);
        System.out.println("\nPrinting the average of students met criteria using average from functional programming : "+averageOfStudentsMetCriteria);

        long countOfStudentsMetCriteria =
                courses.stream().filter(course -> course.getRating() > 90).mapToInt(Course::getNoOfStudents).count();
        System.out.println("\nPrinting the count of students met criteria using count from functional programming : "+countOfStudentsMetCriteria);

        long maxOfNoOfStudentsMetCriteria =
                courses.stream().filter(course -> course.getRating() > 90).mapToInt(Course::getNoOfStudents).max().orElse(0);
        System.out.println("\nPrinting the max of no of students met criteria using count from functional programming : "+maxOfNoOfStudentsMetCriteria);

        long minOfNoOfStudentsMetCriteria =
                courses.stream().filter(course -> course.getRating() > 90).mapToInt(Course::getNoOfStudents).min().orElse(0);
        System.out.println("\nPrinting the min of no of students met criteria using count from functional programming : "+minOfNoOfStudentsMetCriteria);
    }

    /**
     * Method to write examples for take and drop while
     *
     * @param courses
     */
    private static void examplesForTakeDropWhile(List<Course> courses) {
        System.out.println("\nPrinting the courses using take while from functional programming : ");
        courses.stream().takeWhile(course -> course.getRating()>90).forEach(System.out::println);

        System.out.println("\nPrinting the courses using drop while from functional programming : ");
        courses.stream().dropWhile(course -> course.getRating()>90).forEach(System.out::println);
    }

    /**
     * Method to write examples for sorting
     *
     * @param courses
     */
    private static void examplesForSorting(List<Course> courses) {
        Comparator<Course> comparingByRatingIncreasing = Comparator.comparing(Course::getRating);
        System.out.println("Printing the courses in a sorted order based on rating increasing order : ");
        courses.stream().sorted(comparingByRatingIncreasing).forEach(System.out::println);

        Comparator<Course> comparingByRatingDecreasing = Comparator.comparing(Course::getRating).reversed();
        System.out.println("\nPrinting the courses in a sorted order based on rating decreasing order : ");
        courses.stream().sorted(comparingByRatingDecreasing).forEach(System.out::println);

        Comparator<Course> comparingByRatingAndNoOfStudentsDecreasing =
                Comparator.comparing(Course::getRating).thenComparing(Course::getNoOfStudents).reversed();
        System.out.println("\nPrinting the courses in a sorted order based on rating and no of students decreasing order : ");
        courses.stream().sorted(comparingByRatingAndNoOfStudentsDecreasing).forEach(System.out::println);

        System.out.println("\nPrinting the TOP 5 courses in a sorted order based on rating and no of students decreasing order : ");
        courses.stream().sorted(comparingByRatingAndNoOfStudentsDecreasing).limit(5).forEach(System.out::println);

        System.out.println("\nPrinting the courses in a sorted order by skipping TOP 5 based on rating and no of students decreasing order : ");
        courses.stream().sorted(comparingByRatingAndNoOfStudentsDecreasing).skip(5).forEach(System.out::println);

        String courseNameUsingMax = courses.stream().max(comparingByRatingAndNoOfStudentsDecreasing).map(Course::getName).orElse("");
        System.out.println("\nPrinting the course name using MAX on top of sorting : "+courseNameUsingMax);
        String courseNameUsingMin = courses.stream().min(comparingByRatingAndNoOfStudentsDecreasing).map(Course::getName).orElse("");
        System.out.println("\nPrinting the course name using MIN on top of sorting : "+courseNameUsingMin);
    }

    /**
     * Method to write examples for all kind of matches
     *
     * @param courses
     */
    private static void examplesForMatches(List<Course> courses) {
        Predicate<Course> coursePredicate = getCoursePredicate(90);
        boolean allCoursesMatchPredicate = courses.stream().allMatch(coursePredicate);
        boolean anyCourseMatchPredicate = courses.stream().anyMatch(coursePredicate);
        boolean noneCoursesMatchPredicate = courses.stream().noneMatch(coursePredicate);

        System.out.println("Is there a match for all courses in the list with the given predicate : "+allCoursesMatchPredicate);
        System.out.println("Is there a match for any course in the list with the given predicate : "+anyCourseMatchPredicate);
        System.out.println("Is there a match for none courses in the list with the given predicate : "+noneCoursesMatchPredicate);
    }

    /**
     * Method which returns another method ===> this is called as higher order function
     *
     * @param cutOffRating
     * @return
     */
    private static Predicate<Course> getCoursePredicate(int cutOffRating) {
        return course -> cutOffRating <= course.getRating();
    }

}
