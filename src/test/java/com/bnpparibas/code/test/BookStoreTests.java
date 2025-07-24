package com.bnpparibas.code.test;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookStoreTests {


    private final BookStore bookstore = new BookStore();

    @Test
    void testSingleBook() {
        Map<String, Integer> basket = Map.of("Clean Code", 1);
        assertEquals(50.0, bookstore.calculatePrice(basket), 0.01);
    }

    @Test
    void testTwoDifferentBooks() {
        Map<String, Integer> basket = Map.of(
                "Clean Code", 1,
                "Clean Coder", 1
        );
        assertEquals(95.0, bookstore.calculatePrice(basket), 0.01);
    }

    @Test
    void testThreeDifferentBooks() {
        Map<String, Integer> basket = Map.of(
                "Clean Code", 1,
                "Clean Coder", 1,
                "Clean Architecture", 1
        );
        assertEquals(135.0, bookstore.calculatePrice(basket), 0.01);
    }

    @Test
    void testExampleBasket() {
        Map<String, Integer> basket = Map.of(
                "Clean Code", 2,
                "Clean Coder", 2,
                "Clean Architecture", 2,
                "Test Driven Development by Example", 1,
                "Working Effectively With Legacy Code", 1
        );
        // Expected price:
        // (4 books * 50 EUR) - 20% = 160 EUR
        // (4 books * 50 EUR) - 20% = 160 EUR
        // Total = 320 EUR
        assertEquals(320.0, bookstore.calculatePrice(basket), 0.01);
    }

}
