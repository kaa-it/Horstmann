package com.akruglov.chapter01;

/**
 * Created by akruglov on 22.03.17.
 */
public class MyAverage {

    private static double average(double... values) {
        double sum = 0.0;
        for (double v : values) sum += v;
        return values.length == 0 ? 0 : sum / values.length;
    }

    private static double myAverage(double first, double... others) {
        double sum = first;
        for (double v : others) sum += v;
        return others.length == 0 ? sum : sum / (others.length + 1);
    }

    private static void print(double v) {
        System.out.println("Average: " + v);
    }

    public static void main(String[] args) {
        print(average(8));
        print(myAverage(8));
        print(myAverage(8,9));
    }
}
