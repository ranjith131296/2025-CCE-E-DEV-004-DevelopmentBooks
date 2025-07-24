package com.bnpparibas.code.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

    public static List<String> generate(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(FizzBuzz::mapToFizzBuzz)
                .collect(Collectors.toList());
    }

    private static String mapToFizzBuzz(int number) {
        if (number % 15 == 0) return "FizzBuzz";
        if (number % 3 == 0) return "Fizz";
        if (number % 5 == 0) return "Buzz";
        return String.valueOf(number);
    }

}
