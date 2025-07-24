package com.bnpparibas.code.test;

import java.util.*;

public class BookStore {

    private static final double BOOK_PRICE = 50.0;

    private static final Map<Integer, Double> DISCOUNTS = Map.of(
            1, 1.0,
            2, 0.95,
            3, 0.90,
            4, 0.80,
            5, 0.75
    );


    public double calculatePrice(Map<String, Integer> basket) {
        List<Integer> bookCounts = new ArrayList<>(basket.values());
        return findMinPrice(bookCounts);
    }



        private double findMinPrice(List<Integer> counts) {
            if (counts.stream().allMatch(c -> c == 0)) {
                return 0.0;
            }

            double minPrice = Double.MAX_VALUE;

            for (int groupSize = 5; groupSize >= 1; groupSize--) {
                List<Integer> copy = new ArrayList<>(counts);
                int selected = 0;

                for (int i = 0; i < copy.size() && selected < groupSize; i++) {
                    if (copy.get(i) > 0) {
                        copy.set(i, copy.get(i) - 1);
                        selected++;
                    }
                }

                if (selected == groupSize) {
                    double priceForGroup = groupSize * BOOK_PRICE * DISCOUNTS.get(groupSize);
                    double total = priceForGroup + findMinPrice(copy);
                    minPrice = Math.min(minPrice, total);
                }
            }

            return minPrice;
        }

}