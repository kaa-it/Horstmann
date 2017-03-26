package com.akruglov.chapter01;

/**
 * Created by akruglov on 18.03.17.
 */
public class DoubleBoundaries {

    public static void main(String[] args) {
        System.out.printf("Min value: %E, Max value: %E\n", Math.nextUp(0.0), Double.MAX_VALUE);
    }
}
