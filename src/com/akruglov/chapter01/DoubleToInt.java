package com.akruglov.chapter01;

/**
 * Created by akruglov on 18.03.17.
 */
public class DoubleToInt {

    public static void main(String[] args) {
        double value = Double.MAX_VALUE;
        int intValue = (int) value;
        System.out.printf("Double: %E, Int: %d", value, intValue);
    }
}
