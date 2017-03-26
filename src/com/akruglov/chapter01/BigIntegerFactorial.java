package com.akruglov.chapter01;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by akruglov on 18.03.17.
 */
public class BigIntegerFactorial {

    public static void main(String[] args) {
        System.out.println("Enter number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Must be positive.");
            return;
        }

        BigInteger factorial = BigInteger.valueOf(1);

        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Factorial: " + factorial);
    }
}
