package com.kozich.shape.util;

public class EllipseCounter {
    private static long counter;

    public static long generateCounter() {
        return counter++;
    }
}
