package com.learning.functional.programming.runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP05Files {

    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("textFile.txt")).map(fileContent -> fileContent.split(" "))
                .flatMap(Arrays::stream).distinct().forEach(System.out::println);

        /**
         * Some
         * Text
         * File
         * with
         * Content
         * A
         * lot
         * of
         * present
         * in
         * the
         * text
         * file
         */

        Path dir = Paths.get(".");
        Files.list(dir).forEach(System.out::println);

        /**
         * .\.git
         * .\.gitignore
         * .\.idea
         * .\funtional-programming.iml
         * .\out
         * .\src
         * .\textFile.txt
         */

        Files.list(dir).filter(Files::isDirectory).forEach(System.out::println);

        /**
         * .\.git
         * .\.idea
         * .\out
         * .\src
         */
    }
}
