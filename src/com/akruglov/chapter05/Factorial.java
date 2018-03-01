package com.akruglov.chapter05;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorial(int n) {
        if (n == 0 || n == 1) {
            Exception ex = new Exception();
            ex.printStackTrace();
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    public static void main(String[] args) {
        /*Thread.setDefaultUncaughtExceptionHandler((thread, ex) -> {
            ex.printStackTrace();
        });*/

        System.out.println(factorial(100));
    }
}
