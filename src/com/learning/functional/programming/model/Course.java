package com.learning.functional.programming.model;

public class Course {

    private String name;;
    private String category;
    private int rating;
    private int noOfStudents;

    public Course(String name, String category, int rating, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.noOfStudents = noOfStudents;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return name +" "+ category +" "+ rating +" "+ noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
}
