package com.bnpparibas.code.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeapYearTests {


    @Test
    public void isLeapYears() {
        assertTrue(LeapYear.isLeapYear(1600));
        assertTrue(LeapYear.isLeapYear(2000));
        assertTrue(LeapYear.isLeapYear(2400));
    }

    @Test
    public void noLeapYears() {
        assertFalse(LeapYear.isLeapYear(1700));
        assertFalse(LeapYear.isLeapYear(1800));
        assertFalse(LeapYear.isLeapYear(1900));
        assertFalse(LeapYear.isLeapYear(2100));
    }

    @Test
    public void divisibleBy4NotLeapYears() {
        assertTrue(LeapYear.isLeapYear(2008));
        assertTrue(LeapYear.isLeapYear(2012));
        assertTrue(LeapYear.isLeapYear(2016));
    }

    @Test
    public void notDivisibleBy4NotLeapYears() {
        assertFalse(LeapYear.isLeapYear(2017));
        assertFalse(LeapYear.isLeapYear(2018));
        assertFalse(LeapYear.isLeapYear(2019));
    }

}
